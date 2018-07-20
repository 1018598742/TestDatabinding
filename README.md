# DATABIND 使用

通过慕课网MarkZhai视频学习到的知识

build.gradle中android标签下添加

```
android {
    dataBinding {
        enabled = true
    }
}
```

在布局xml文件最外层添加

```
<layout>
	
</layout>
```

加入上面的xml文件名为activity_demo.xml那么生成的databinding名字为ActivityDemoBinding

```
ActivityDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_demo);
```

## 绑定数据的方式

1. 方法引用

   ``` 
   使用的方法名要一致，xml中使用@{presenter.onClick}
   ```

   ​

2. 监听器引用

   ```
   使用的方法可以自己定义，在xml中使用格式为android:onClick="@{()-> presenter.onClickListenerBinding(fta)}"其中fta为自己定义的参数
   ```

   ## 基本原理

   - android.binding
   - BR
   - XxxBinding

   ## 表达式

   取非空表达式

   ```
   android:text= "@{user.displayName ?? user.lastName}" 取两个中第一个非空的值
   ```

   Margin @dimen + @dimen 可以使用值相加

## 避免空指针

- 自动空指针检查

{user.name} 如果检测到user是空，会返回name的默认值，比如name是string返回null,name是int返回 0；

- 数组越界

  没办法检查，自己写的时候注意




## demo包含

- ```
  DemoActiviey
  包含基本的绑定方式，通过设置监听改变数据
  ```

- ```
  TwoWayActivity
  双向绑定，不用是指监听，直接改变数据
  ```

- ```
  ExpressionActivity
  自定义属性绑定，演示为通过自定义adapter获取网络图片设置
  还包括链式更新和隐式更新
  ```

- ```
  ListActivity
  对于recyclerview的数据绑定演示
  ```

- ```
  LambdaActivity
  布局中使用lambda的演示
  ```

- ```
  AnimationActivity
  动画演示，通过点击显示图片不让他太突兀，添加的动画方法最低api为19
  ```