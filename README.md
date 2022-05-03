Bad Weather

APP介绍与使用
  本项目没有自己搭建后台，所以自然不会有什么服务器数据库，数据来源于和风天气API 将项目导入到Android Studio 有如下两种方式：

复制 https://github.com/MsGuaiWu/BadWeather.git 在AS的导航栏中 VSC → Checkout from Version Control → Git .然后会弹出一个克隆项目的弹窗，粘贴刚才复制的地址，点击弹窗的Clone按钮就可以克隆GitHub上的项目到自己的AS中了。不过这个时候是比较看你的网速的，项目中的很多内容与你本地环境不同，所以需要下载和配置才行。
点击绿色的Code按钮，点击Download ZIP，直接下载压缩包到电脑本地，然后解压，通过AS 的导航栏 File → Open 找到刚才解压之后的文件，然后就是同步和配置即可。
答疑
  在Clone源码到本地Android Studio中DeBug运行时，进入地图页面时，发现没有定位或者是无反应，请检查Run下面的日志信息，看有无 "鉴权错误信息" 等字样，如果有的话则说明你需要使用自己项目生成的开发版SHA1,替换掉平台上的应用配置信息
  Windows中GitHub图片显示异常解决方法：打开hosts文件所在目录，C:\Windows\System32\drivers\etc\hosts，默认我们对hosts文件是没有修改权限的，需要开启修改权限，开启修改权限后，用随便用一个编辑器打开，添加的内容请参考这个hosts文件中最后的部分，对比你的本地进行添加即可。（注意这个开始和结束的标识）

APP功能描述
  15天天气预报、空气质量、生活建议、出行建议、灾害预警、分钟级降水、城市切换、城市搜索、常用城市、世界国家/地区的城市、壁纸切换、壁纸下载、地图天气、地图搜索定位、每日提醒、语音播报、语音搜索、快捷切换常用城市、应用自动更新、错误监控

Android 天气APP（一）开发准备
Android 天气APP（二）获取定位信息
Android 天气APP（三）访问天气API与数据请求
Android 天气APP（四）搭建MVP框架与使用
Android 天气APP（五）天气预报、生活指数的数据请求与渲染
Android 天气APP（六）旋转风车显示风力、风向
Android 天气APP（七）城市切换 之 城市数据源
Android 天气APP（八）城市切换 之 自定义弹窗与使用
Android 天气APP（九）细节优化、必应每日一图
Android 天气APP（十）继续优化、下拉刷新页面天气数据
Android 天气APP（十一）未来七天的天气预报、逐小时预报、UI优化
Android 天气APP（十二）空气质量、UI优化调整
Android 天气APP（十三）仿微信弹窗(右上角加号点击弹窗效果)、自定义背景图片、UI优化调整
Android 天气APP（十四）修复UI显示异常、优化业务代码逻辑、增加详情天气显示
Android 天气APP（十五）增加城市搜索、历史搜索记录
Android 天气APP（十六）热门城市 - 海外城市
Android 天气APP（十七）热门城市 - 国内城市
Android 天气APP（十八）常用城市
Android 天气APP（十九）更换新版API接口（更高、更快、更强）
Android 天气APP（二十）增加欢迎页及白屏黑屏处理、展示世界国家/地区的城市数据
Android 天气APP（二十一）滑动改变UI、增加更多天气数据展示，最多未来15天天气预报
Android 天气APP（二十二）改动些许UI、增加更多空气质量数据和生活建议数据展示
Android 天气APP（二十三）增加灾害预警、优化主页面UI
Android 天气APP（二十四）地图天气（上）自动定位和地图点击定位
Android 天气APP（二十五）地图天气（下）嵌套滑动布局渲染天气数据
Android 天气APP（二十六）增加自动更新（检查版本、通知栏下载、自动安装）
Android 天气APP（二十七）增加地图天气的逐小时天气、太阳和月亮数据
Android 天气APP（二十八）地图搜索定位
Android 天气APP（二十九）壁纸设置、图片查看、图片保存
Android 天气APP（三十）分钟级降水
Android 天气APP（三十一）每日提醒弹窗
Android 天气APP（三十二）快捷切换常用城市
Android 天气APP（三十三）语音播报
Android 天气APP（三十四）语音搜索
Android 天气APP（三十五）修复BUG、升级网络请求框架
V 1.2
增加用户体验，允许自己修改背景
V 1.1
七天天气预报、逐小时天气预报、界面UI优化
V 1.0
初始版本、三天天气预报、空气质量、城市切换、生活指数
