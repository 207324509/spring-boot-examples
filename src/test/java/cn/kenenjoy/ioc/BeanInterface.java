package cn.kenenjoy.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by hefa on 2018/1/10.
 */
public interface BeanInterface {
    void say();
}

@Component
class BeanImplOne implements BeanInterface {
    public void say() {
        System.out.println(this.getClass().getName());
    }
}

@Component
class BeanImplTwo implements BeanInterface {
    public void say() {
        System.out.println(this.getClass().getName());
    }
}

@Component
class BeanInvoker {

    @Autowired
    private List<BeanInterface> list;

    @Autowired
    private Map<String, BeanInterface> map;

    public void say() {
        if (null != list && 0 != list.size()) {
            for (BeanInterface bean : list) {
                System.out.println(bean.getClass().getName());
            }
        } else {
            System.out.println(" list is null !");
        }

        if (null != map && 0 != map.size()) {
            for (Map.Entry<String, BeanInterface> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "   " + entry.getValue().getClass().getName());
            }
        } else {
            System.out.println("map is null !");
        }
    }
}
