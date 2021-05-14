package com.github.lzj960515.mock.util;

import com.github.lzj960515.mock.annotation.Address;
import com.github.lzj960515.mock.annotation.Age;
import com.github.lzj960515.mock.annotation.Avatar;
import com.github.lzj960515.mock.annotation.Chinese;
import com.github.lzj960515.mock.annotation.Date;
import com.github.lzj960515.mock.annotation.DateTime;
import com.github.lzj960515.mock.annotation.Disease;
import com.github.lzj960515.mock.annotation.Entity;
import com.github.lzj960515.mock.annotation.Gender;
import com.github.lzj960515.mock.annotation.Hospital;
import com.github.lzj960515.mock.annotation.IdNumber;
import com.github.lzj960515.mock.annotation.Medicine;
import com.github.lzj960515.mock.annotation.Name;
import com.github.lzj960515.mock.annotation.Number;
import com.github.lzj960515.mock.annotation.Phone;
import com.github.lzj960515.mock.annotation.Price;
import com.github.lzj960515.mock.annotation.Symptoms;
import com.github.lzj960515.mock.annotation.University;
import com.github.lzj960515.mock.core.AddressMock;
import com.github.lzj960515.mock.core.AgeMock;
import com.github.lzj960515.mock.core.AvatarMock;
import com.github.lzj960515.mock.core.DateMock;
import com.github.lzj960515.mock.core.DateTimeMock;
import com.github.lzj960515.mock.core.DefaultMock;
import com.github.lzj960515.mock.core.DiseaseMock;
import com.github.lzj960515.mock.core.GenderMock;
import com.github.lzj960515.mock.core.HospitalMock;
import com.github.lzj960515.mock.core.IdNumberMock;
import com.github.lzj960515.mock.core.MedicineMock;
import com.github.lzj960515.mock.core.Mock;
import com.github.lzj960515.mock.core.NameMock;
import com.github.lzj960515.mock.core.NumberMock;
import com.github.lzj960515.mock.core.PhoneMock;
import com.github.lzj960515.mock.core.PriceMock;
import com.github.lzj960515.mock.core.ChineseMock;
import com.github.lzj960515.mock.core.SymptomsMock;
import com.github.lzj960515.mock.core.UniversityMock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * mock util
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
@Slf4j
public class MockUtil {

    private static Map<String, Mock> MOCK_MAP = new HashMap<>();
    private static DefaultMock DEFAULT_MOCK = new DefaultMock();

    static {
        MOCK_MAP.put(Name.class.getSimpleName(), new NameMock());
        MOCK_MAP.put(Age.class.getSimpleName(), new AgeMock());
        MOCK_MAP.put(Number.class.getSimpleName(), new NumberMock());
        MOCK_MAP.put(Gender.class.getSimpleName(), new GenderMock());
        MOCK_MAP.put(Address.class.getSimpleName(), new AddressMock());
        MOCK_MAP.put(Avatar.class.getSimpleName(), new AvatarMock());
        MOCK_MAP.put(Date.class.getSimpleName(), new DateMock());
        MOCK_MAP.put(DateTime.class.getSimpleName(), new DateTimeMock());
        MOCK_MAP.put(Disease.class.getSimpleName(), new DiseaseMock());
        MOCK_MAP.put(Hospital.class.getSimpleName(), new HospitalMock());
        MOCK_MAP.put(IdNumber.class.getSimpleName(), new IdNumberMock());
        MOCK_MAP.put(Medicine.class.getSimpleName(), new MedicineMock());
        MOCK_MAP.put(Phone.class.getSimpleName(), new PhoneMock());
        MOCK_MAP.put(Price.class.getSimpleName(), new PriceMock());
        MOCK_MAP.put(Symptoms.class.getSimpleName(), new SymptomsMock());
        MOCK_MAP.put(University.class.getSimpleName(), new UniversityMock());
        MOCK_MAP.put(Chinese.class.getSimpleName(), new ChineseMock());
    }

    private static Random random = new Random();

    public static <T> T mock(Class<T> clazz){
        return doMock(clazz);
    }

    public static <T> T doMock(Class<T> clazz){
        T obj;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        ReflectionUtils.doWithFields(clazz, field -> {
            if (Modifier.isStatic(field.getModifiers())) {
                return;
            }
            field.setAccessible(true);
            Type genericType = field.getGenericType();
            Class<?> type = field.getType();
            // 判断是否为简单类型
            if(!BeanUtils.isSimpleProperty(type)){
                if (Collection.class.isAssignableFrom(type)) {
                    int size = random.nextInt(10);
                    Collection<Object> result;
                    if (List.class.isAssignableFrom(type)) {
                        result = new ArrayList<>(size);
                    } else {
                        result = new HashSet<>(size);
                    }
                    Type actualType = ((ParameterizedType) genericType).getActualTypeArguments()[0];

                    for (int index = 0; index < size; index++) {
                        result.add(doMock((Class<T>) actualType));
                    }
                    field.set(obj, result);
                    return;
                }
            }
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if(annotation instanceof Entity){
                    field.set(obj, doMock(field.getType()));
                    return;
                }

                Mock mock = MOCK_MAP.get(annotation.annotationType().getSimpleName());
                if(mock != null){
                    Object mockData = mock.getMockData(annotation);
                    try{
                        field.set(obj, mockData);
                    }catch (IllegalArgumentException e){
                        // 尝试转成String设置，依旧不行则不再处理异常
                        field.set(obj, String.valueOf(mockData));
                    }
                    return;
                }
            }
            field.set(obj, DEFAULT_MOCK.getMockData(null));
        });
        return obj;
    }
}
