<div dir="rtl" align="right">

<style>
body {
  direction: rtl;
  text-align: right;
  font-family: Tahoma, sans-serif;
}
</style>

# مدیریت سامانه آموزشگاه

## کلاس <code dir="ltr">Student</code>

این کلاس نماینده‌ی یک دانشجو است که اطلاعات فردی و دوره‌هایی را که در آن‌ها ثبت‌نام کرده نگهداری می‌کند.

### ویژگی‌ها

- <code dir="ltr">int studentId</code> : شناسه‌ی یکتای دانشجو
- <code dir="ltr">String name</code> : نام دانشجو
- <code dir="ltr">List&lt;Course&gt;</code> : لیست دوره‌هایی که دانشجو در آن‌ها ثبت‌نام کرده است

### متدها

- <code dir="ltr">Student(int studentId, String name)</code> : سازنده‌ی کلاس برای مقداردهی اولیه
- <code dir="ltr">void addCourse(Course course)</code> : افزودن دوره جدید، تنها در صورتی که قبلاً اضافه نشده باشد
- <code dir="ltr">List&lt;Course&gt; getCourses()</code> : دریافت لیست دوره‌های دانشجو

---

## کلاس <code dir="ltr">Course</code>

این کلاس نماینده‌ی یک دوره آموزشی است و اطلاعات دانشجویان ثبت‌نام‌شده در آن را نگهداری می‌کند.

### ویژگی‌ها

- <code dir="ltr">String courseCode</code> : کد یکتای دوره
- <code dir="ltr">int capacity</code> : ظرفیت دوره
- <code dir="ltr">List&lt;Student&gt;</code> : دانشجویان ثبت‌نام‌شده در دوره

### متدها

- <code dir="ltr">Course(String courseCode, int capacity)</code> : سازنده‌ی کلاس
- <code dir="ltr">boolean enrollStudent(Student student)</code> : ثبت‌نام دانشجو در دوره، فقط در صورتی که ظرفیت پر نشده باشد و دانشجو قبلاً ثبت‌نام نکرده باشد
- <code dir="ltr">int getAvailableSeats()</code> : دریافت تعداد ظرفیت باقی‌مانده دوره

---

## کلاس <code dir="ltr">AcademySystem</code>

این کلاس هسته‌ی اصلی سامانه آموزشگاه است و امکان مدیریت دانشجویان، دوره‌ها و ثبت‌نام‌ها را فراهم می‌کند.

### ویژگی‌ها

- <code dir="ltr">Map&lt;Integer, Student&gt;</code> : دانشجویان با شناسه یکتا
- <code dir="ltr">Map&lt;String, Course&gt;</code> : دوره‌ها با کد یکتا

### متدها

- <code dir="ltr">void addStudent(Student student)</code> : افزودن دانشجوی جدید
- <code dir="ltr">void addCourse(Course course)</code> : افزودن دوره جدید
- <code dir="ltr">boolean enrollStudentInCourse(int studentId, String courseCode)</code> : ثبت‌نام دانشجو در دوره، فقط در صورتی که دانشجو و دوره موجود باشند و ظرفیت کافی باشد
- <code dir="ltr">Student getStudent(int studentId)</code> : دریافت اطلاعات دانشجو
- <code dir="ltr">Course getCourse(String courseCode)</code> : دریافت اطلاعات دوره

---

## محدودیت‌ها

- ثبت‌نام فقط در صورتی انجام می‌شود که دانشجو و دوره در سامانه موجود باشند.
- اگر ظرفیت دوره پر باشد، ثبت‌نام انجام نمی‌شود.
- اگر دانشجو قبلاً در همان دوره ثبت‌نام کرده باشد، ثبت‌نام دوباره انجام نمی‌شود.

---

## نمونه‌ی استفاده

<pre dir="ltr"><code>Student student = new Student(101, "Ali");
Course course = new Course("JAVA101", 2);

AcademySystem system = new AcademySystem();
system.addStudent(student);
system.addCourse(course);

system.enrollStudentInCourse(101, "JAVA101");</code></pre>

./gradlew clean test

# push changes to the repository:
git add .
git commit -m "commit message"
git push</code></pre>

</div>
