# WorkStudy
### Intent

Intent在活动之间穿梭，activity，服务，发送广播，打开网页，电话等等，分为显示和隐示两种

###### 显示：

```java
Intent intent = new  Intent(this, TestActivity.class);
startActivity(intent);
```
###### 隐示：

没有指定活动，要配合action，category，只有这两个能同时匹配上intent中指定的action，category才能启动活动，一般AndroidManifest中会有默认的action，category，后续可以自行添加。

Intent传递数据

使用putExtra,把数据存在intent中，就可以在启动另一个活动的时候把数据传递过去，一般使用两种方法(Serializable, Parcelable)传递对象

返回数据给上一个活动（不能和传递数据同时进行）

主要使用startActivityForResult(intent,1);第二个参数为请求码，然后在Bactivity中注册按钮点击事件，并添加返回逻辑，在Aactivity中接受返回数据，如果用户直接点击back，则可以直接重写OnBackPressed()方法。

### LunchMode

LaunchMode就是启动模式，LaunchMode启动Activity，面对不同发需求，使用不同的启动模式启动的Activity有不同的属性和表现。

在Mainfest中的activity节点中添加android:launchMode即可


有四种启动模式

l “standard”：标准模式，在activity A中创建activity B，点击几次就创建几次，一般用于大部分应用，例如给张三发完邮件，又给李四发邮件

l “singleTop”：如果栈顶已经有了同样的activity，那么不会创建重复的activity，一般用于视频播放，以免用户创建多个播放页面

l “singleTask”：不会创建activity，会销毁其他activity，把当前activity放到BackTask的栈顶，例如在播放视频时搜索，返回后还是播放页面。

l “singleInstance”：创建activity在新的BackTask中

l “standard”、“singleTop”:可以被实例化多次,他们的实例可以属于任何Task，并且可以位于Back Stack的任何位置，

l “singleTask”、“singleInstance”:属于不可被实例化多次，他们常用于启动一个Task，所以一个Task只有一个这种实例，并且这个还往往位于Back Stack的最开始

**StartActivityForResult和“SingleTask”属性的问题**

 当启动的activity B是singleTask时, activity A和activity B两个activity不在同一个任务栈中（这个地方有歧义，实际上以singleTask启动模式启动一个activity并不一定会重新开启一个任务栈，只有当系统中不存在与该activity的TaskAffinity相同的任务栈时，系统才会创建一个新的任务栈），所以activity A将会立即得到一个cancel的结果。
     所以为了满足任务栈中只存在一个activity B，同时又能够正常使用activity的startActivityForResult，我们可以将activity的启动模式设置为standard同时将intent添加一个flag：Intent.FLAG_CTIVITY_CLEAR_TOP.

###### **Activity生命周期**

Task 栈；要做的任务：例如发短信，打电话

BackTask 回退栈，存放做任务需要用到的activity

例如

l 发短信的短信主界面，MainActivity

l 点击添加按钮，进入短信新建界面，打开SendActivity

l 在SendActivity中短信编辑完成发送

其在栈中的顺序是

l MainActivity先存入栈内

l 点击添加按钮，打开SendActivity接着存入栈内

l 短信发送完成，点击返回按钮，SendActivity从栈中弹出，回到MainActivity

l 在MainActivity点击返回按钮，MainActivity从栈中弹出，此时该Back Stack为空，就返回到Launcher了

每个Task都会有一个BackTask，每个BackTask都至少有一个Activity，执行Task是，会先创立一个BackTask，然后把用到的activity按顺序存放在BackTask中，任务完成后，会按照存栈顺序依次弹栈，直到栈为空，进入Launcher。

每个活动的生命周期最多会有四种状态：运行，暂停，停止，销毁.

### RecyclerView

ViewHolder继承RecyclerView.ViewHolder

先获取控件实例

再重写onCreateViewHolder：创建ViewHolder，把定义的布局加载到里面,

onBindViewHolder：对列表每一项的进行内容的赋值,

 getItemCount：指定列表有几项.

这三个方法

在ViewAdapter方法中把数据赋值给全局变量

在MainActivity中初始化数据

然后创建RecyclerView的实例，用LayoutManage来控制列表布局方式，并用setLayoutManager把它设置到RecyclerView中，设置ViewAdapter实例，把数据传入到构造函数中，最后调用setAdapter完成适配器设置.

 