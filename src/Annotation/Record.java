package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Record {
    @Field_Method_Parameter_Annotation(describe = "编号",type = int.class)
    //注释字段
    int id;
    @Field_Method_Parameter_Annotation(describe = "姓名",type = String.class)
    String name;

    @Constructor_Annotation()
    //采用默认值注释构造方法
    public Record(){}

    @Constructor_Annotation("立即初始化构造方法")
    public Record(//注释构造方法
        @Field_Method_Parameter_Annotation(describe = "编号",type = int.class)int id,
        @Field_Method_Parameter_Annotation(describe = "姓名",type = String.class) String name){
        this.id=id;
        this.name=name;
    }

    @Field_Method_Parameter_Annotation(describe = "获得编号",type = int.class)
    public int getId(){//注释方法
        return id;
    }

    @Field_Method_Parameter_Annotation(describe = "设置编号",type = int.class)
    public void setId(//成员type采用默认注释方法
        //注释方法参数
                    @Field_Method_Parameter_Annotation(describe = "编号",type = int.class) int id){
        this.id=id;
    }

    @Field_Method_Parameter_Annotation(describe = "获得姓名",type = String.class)
    public String getName(){//注释方法
        return name;
    }

    @Field_Method_Parameter_Annotation(describe = "设置姓名",type = String.class)
    public void setName(//成员type采用默认注释方法
                      //注释方法参数
                      @Field_Method_Parameter_Annotation(describe = "姓名",type = String.class) String name){
        this.name = name;
    }

    //查询构造函数包含的Annotation信息
    public void getConstructorAnnotation() {
        Class recordC = this.getClass();
        Constructor[] declaredConstructors = recordC.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor constructor = declaredConstructors[i];
            //查看是否含有指定类型的注释
            //如果constructor拥有Constructor_Annotation注释
            if (constructor.isAnnotationPresent(Constructor_Annotation.class)){
                //获得指定类型的注释
                Constructor_Annotation ca =
                        (Constructor_Annotation) constructor.getAnnotation(Constructor_Annotation.class);
                System.out.println(ca.value());
            }
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            for (int j = 0; j < parameterAnnotations.length; j++) {
                int length = parameterAnnotations[j].length;
                if(length==0)
                    System.out.println("未添加Annotation参数");
                else
                    for (int k = 0; k < length; k++) {
                        Field_Method_Parameter_Annotation pa =
                                (Field_Method_Parameter_Annotation) parameterAnnotations[j][k];
                        System.out.print("参数类型："+pa.type());
                        System.out.println("  参数类型："+pa.describe());
                    }
            }

        }
        System.out.println();
    }


    public void getFieldAnnotation(){
        Class recordC = this.getClass();
        Field[] fields = recordC.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if(field.isAnnotationPresent(Field_Method_Parameter_Annotation.class)){
                Field_Method_Parameter_Annotation ff = field.getAnnotation(Field_Method_Parameter_Annotation.class);
                System.out.println("成员变量类型： " + ff.type());
                System.out.println("成员变量描述： "+ ff.describe());
            }
        }
    }

    public static void main(String[] args) {
        Record record = new Record();
        record.getConstructorAnnotation();
        record.getFieldAnnotation();
    }
}
