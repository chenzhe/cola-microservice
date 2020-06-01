package cn.startom.mall.account.common;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

public class CommonConvertor {
    /**
     * 从一个对象转成另一个对象
     * @param source 原对象
     * @param dClass 目标对象类型
     * @param <D>
     * @return 返回目标对象实例
     */
    public static <D> D convertTo(Object source,Class<D> dClass){
        Mapper mapper= DozerBeanMapperSingletonWrapper.getInstance();
        return mapper.map(source,dClass);
    }
}
