<div dir="rtl" align="right">

# Parking Permit System

# سامانه مدیریت مجوز پارکینگ

## توضیحات کلی

در این پروژه، هدف ساخت یک سیستم ساده برای مدیریت کاربران دارای مجوز پارکینگ است.

سیستم شامل دو کلاس اصلی است:

- <code dir="ltr">ParkingUser</code> : نماینده‌ای برای هر کاربر پارکینگ با اطلاعات پایه مانند نام، نام خانوادگی و شماره مجوز.
- <code dir="ltr">ParkingManager</code> : کلاسی برای مدیریت مجموعه کاربران، شامل اضافه‌کردن کاربر جدید و گزارش وضعیت کاربران.

---

## کلاس <code dir="ltr">ParkingUser</code>

کلاسی برای تعریف اطلاعات هر کاربر پارکینگ.

### فیلدها

- <code dir="ltr">String firstName</code> : نام کاربر
- <code dir="ltr">String lastName</code> : نام خانوادگی کاربر
- <code dir="ltr">String permitId</code> : شماره مجوز پارکینگ
- <code dir="ltr">boolean isActive</code> : وضعیت فعال یا غیرفعال بودن مجوز
- <code dir="ltr">String lastEntry</code> : تاریخ آخرین ورود به پارکینگ، به صورت رشته‌ای

---

### متدها

- <code dir="ltr">ParkingUser(String firstName, String lastName, String permitId)</code>  
  سازنده کلاس برای مقداردهی اولیه

- Getter و Setter برای تمام فیلدها

- <code dir="ltr">String displayUserInfo()</code>  
  بازگرداندن اطلاعات کاربر به صورت یک رشته

- <code dir="ltr">void deactivatePermit()</code>  
  غیرفعال کردن مجوز پارکینگ

- <code dir="ltr">void activatePermit()</code>  
  فعال کردن مجوز پارکینگ

- <code dir="ltr">void updateLastEntry(String datetime)</code>  
  به‌روزرسانی تاریخ آخرین ورود

---

## کلاس <code dir="ltr">ParkingManager</code>

کلاسی برای مدیریت کاربران پارکینگ، مانند یک بانک اطلاعاتی کوچک.

### فیلدها

- <code dir="ltr">List&lt;ParkingUser&gt; users</code> : لیستی از کاربران موجود

---

### متدها

- <code dir="ltr">void addUser(ParkingUser user)</code>  
  افزودن کاربر جدید

- <code dir="ltr">List&lt;ParkingUser&gt; getAllUsers()</code>  
  گرفتن لیست همه کاربران

- <code dir="ltr">ParkingUser findUserByPermitId(String permitId)</code>  
  جستجوی کاربر از طریق شماره مجوز

- <code dir="ltr">List&lt;ParkingUser&gt; getActiveUsers()</code>  
  دریافت لیست کاربران دارای مجوز فعال

- <code dir="ltr">List&lt;ParkingUser&gt; getInactiveUsers()</code>  
  دریافت لیست کاربران دارای مجوز غیرفعال

---

## نکته‌های مهم

- مقدار پیش‌فرض <code dir="ltr">isActive</code> باید برابر <code dir="ltr">false</code> باشد.
- مقدار پیش‌فرض <code dir="ltr">lastEntry</code> باید برابر <code dir="ltr">"-"</code> باشد.
- جستجو بر اساس <code dir="ltr">permitId</code> باید نسبت به حروف بزرگ و کوچک حساس نباشد.
- متد <code dir="ltr">getAllUsers()</code> نباید لیست اصلی داخل کلاس را مستقیماً برگرداند.

---

## مثال استفاده

<pre dir="ltr"><code>ParkingManager manager = new ParkingManager();

ParkingUser u1 = new ParkingUser("Alice", "Smith", "P001");
ParkingUser u2 = new ParkingUser("Bob", "Johnson", "P002");

manager.addUser(u1);
manager.addUser(u2);

u1.activatePermit();
u1.updateLastEntry("2025-10-09 09:30");

System.out.println(manager.findUserByPermitId("P001").getFirstName()); // Alice
System.out.println(manager.getActiveUsers().size()); // 1</code></pre>


## دستورات کار با پروژه

<pre dir="ltr"><code># clone in your computer:
git clone your_repo_url
cd your_repo_dir

# run tests from terminal:
./gradlew clean test

# push changes to the repository:
git add .
git commit -m "commit message"
git push</code></pre>

</div>