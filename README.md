# spring boot后端编程

##  1.基本目录结构
![](https://github.com/cordercorder/Transfer-Station-in-Cloud-Server-Files/blob/master/base.JPG)

> **其中**
> + **controller下写业务逻辑**
> + **domain下写实体(数据库表的实体或者我们自己创建的实体)**
> + **mapper下写数据库交的互接口**
> + **service下写对各个数据库的具体操作的方法，并在impl中实现该方法，这个就不再多说了**
***
## 2.举个小例子
### 假如我们正在为查询成绩的功能写后端(给老师的登陆界面写后端)，我们要查询出所有选了这门课的学生成绩，该怎么办？
**我们需要考虑，在老师登陆这个系统时，老师应该看到的前端界面应该包含哪些信息？**

**老师看到的基本信息应该有：课程名称，选课的学生学号，选课的学生姓名，选课的学生班级，选课的学生成绩等......**

**OK,那么我们就应该去数据库里面查询这些信息，这个用一行`sql`语句就能搞定了，由于学生姓名，学生班级等信息在`student`表中，课程名称在`course`表中，选课信息在`choose_course`表中，所以我们可以写一个多表连接查询的`sql`语句(当然嵌套查询也可以)。**

**例如`select student.number,student.name,student.class,course.name,choose_course.score,choose_course.gpa from choose_course,student,course where choose_course.course_number=course.number and choose_course.student_number=student.number and choose_course.course_number='CS001'`就是查询出选了课程号为`CS001`课程的所有学生的基本信息和成绩，那么我根据这些信息就到`domain`下创建一个相应的实体**
### 创建的实体如下
![](https://github.com/cordercorder/Transfer-Station-in-Cloud-Server-Files/blob/master/base2.JPG)

**本来编译器应该会为根据我们查询的'sql'语句为我们自动生成一个构造函数，但是由于我们这里需要将查询出来的结果做一个转换(把查询出来的包含平时成绩，期中成绩，期末成绩的混合成绩换为真实的成绩)，所以在这里我们自己写一个构造函数，我们写的构造函数如下：**

![](https://github.com/cordercorder/Transfer-Station-in-Cloud-Server-Files/blob/master/base3.JPG)

**OK，现在我们已经写好了实体，可以在`mapper`下写`sql`语句了，下面右边的红框中是我们写的`sql`语句和对应的数据库的接口，接口的参数为课程号(由于返回的是多个学生的成绩，所以函数的返回值是`List<StudentScore>`)**
![](https://github.com/cordercorder/Transfer-Station-in-Cloud-Server-Files/blob/master/base4.JPG)

**然后我们在`service`下定义一个查询学生成绩的接口**
![](https://github.com/cordercorder/Transfer-Station-in-Cloud-Server-Files/blob/master/base5.JPG)

**接下来我们到`impl`下去实现这个接口**
![](https://github.com/cordercorder/Transfer-Station-in-Cloud-Server-Files/blob/master/base6.JPG)

**接下来我们到`controller`下写业务逻辑(在这里为了方便，`coursenumber`参数设置为固定值`CS001`)**
![](https://github.com/cordercorder/Transfer-Station-in-Cloud-Server-Files/blob/master/base8.JPG)

**接下来我们访问`http://localhost:8080/student_score_query`就能看到选了课程号为`CS001`课程的学生成绩了(注意，对应的实体中有了`getter`方法的数据才能展示出来)**
![](https://github.com/cordercorder/Transfer-Station-in-Cloud-Server-Files/blob/master/base7.JPG)

## 代码已经上传到了我们班的`github`，可以随时查看
