<div dir="rtl" align="right">

<style>
body {
  direction: rtl;
  text-align: right;
  font-family: Tahoma, sans-serif;
}
</style>

# مدیریت سامانه اجاره تجهیزات ورزشی

## کلاس <code dir="ltr">Equipment</code>

این کلاس نماینده‌ی یک وسیله ورزشی است که اطلاعات وسیله و وضعیت اجاره آن را نگهداری می‌کند.

### ویژگی‌ها

- <code dir="ltr">String equipmentCode</code> : کد یکتای وسیله
- <code dir="ltr">String name</code> : نام وسیله
- <code dir="ltr">boolean isAvailable</code> : وضعیت در دسترس بودن وسیله
- <code dir="ltr">Map&lt;Client, RentAgreement&gt;</code> : مشتریان و اطلاعات اجاره آن‌ها

### متدها

- <code dir="ltr">Equipment(String equipmentCode, String name)</code> : سازنده‌ی کلاس
- <code dir="ltr">boolean rentEquipment(Client client, RentAgreement rentAgreement)</code> : اجاره وسیله، تنها در صورتی که وسیله در دسترس باشد
- <code dir="ltr">boolean returnEquipment(Client client)</code> : بازگرداندن وسیله و تغییر وضعیت به در دسترس
- <code dir="ltr">Map&lt;Client, RentAgreement&gt; getRentalHistory()</code> : دریافت تاریخچه اجاره‌ها

### محدودیت‌ها

- وسیله فقط زمانی قابل اجاره است که در دسترس باشد.

---

## کلاس <code dir="ltr">Client</code>

این کلاس نماینده‌ی یک مشتری است که اطلاعات فردی و تجهیزات اجاره‌شده را نگهداری می‌کند.

### ویژگی‌ها

- <code dir="ltr">int clientId</code> : شناسه یکتای مشتری
- <code dir="ltr">String name</code> : نام مشتری
- <code dir="ltr">Map&lt;Equipment, RentAgreement&gt;</code> : تجهیزات اجاره‌شده و اطلاعات اجاره

### متدها

- <code dir="ltr">Client(int clientId, String name)</code> : سازنده‌ی کلاس
- <code dir="ltr">boolean rentEquipment(Equipment equipment, RentAgreement rentAgreement)</code> : ثبت اجاره وسیله، تنها در صورتی که وسیله در دسترس باشد
- <code dir="ltr">boolean returnEquipment(Equipment equipment)</code> : بازگرداندن وسیله
- <code dir="ltr">Map&lt;Equipment, RentAgreement&gt; getRentedEquipments()</code> : دریافت تجهیزات اجاره‌شده

### محدودیت‌ها

- مشتری نمی‌تواند وسیله‌ای را اجاره کند که در دسترس نیست.

---

## کلاس <code dir="ltr">RentAgreement</code>

این کلاس اطلاعات جزئیات هر اجاره را نگهداری می‌کند.

### ویژگی‌ها

- <code dir="ltr">Date startDate</code> : تاریخ شروع اجاره
- <code dir="ltr">Date endDate</code> : تاریخ پایان اجاره
- <code dir="ltr">double price</code> : قیمت کل اجاره

### متدها

- <code dir="ltr">RentAgreement(Date startDate, Date endDate, double price)</code> : سازنده‌ی کلاس
- <code dir="ltr">boolean extendAgreement(Date newEndDate, double additionalPrice)</code> : تمدید اجاره

### محدودیت‌ها

- تاریخ پایان جدید باید بعد از تاریخ پایان فعلی باشد.

---

## کلاس <code dir="ltr">EquipmentRentalSystem</code>

این کلاس هسته‌ی اصلی سامانه اجاره تجهیزات ورزشی است و امکان مدیریت تجهیزات، مشتریان و اجاره‌ها را فراهم می‌کند.

### ویژگی‌ها

- <code dir="ltr">Map&lt;String, Equipment&gt;</code> : تجهیزات با کد یکتا
- <code dir="ltr">Map&lt;Integer, Client&gt;</code> : مشتریان با شناسه یکتا

### متدها

- <code dir="ltr">void addEquipment(Equipment equipment)</code> : افزودن وسیله
- <code dir="ltr">void addClient(Client client)</code> : افزودن مشتری
- <code dir="ltr">boolean rentEquipmentToClient(int clientId, String equipmentCode, RentAgreement rentAgreement)</code> : اجاره وسیله به مشتری
- <code dir="ltr">boolean returnEquipmentFromClient(int clientId, String equipmentCode)</code> : بازگرداندن وسیله از مشتری
- <code dir="ltr">Client getClient(int clientId)</code> : دریافت اطلاعات مشتری
- <code dir="ltr">Equipment getEquipment(String equipmentCode)</code> : دریافت اطلاعات وسیله

### محدودیت‌ها

- وسیله فقط زمانی اجاره داده می‌شود که در دسترس باشد.
- بازگرداندن وسیله فقط در صورتی انجام می‌شود که همان مشتری وسیله را اجاره کرده باشد.
- همه کلاس‌ها باید از <code dir="ltr">Map</code> برای ذخیره اطلاعات استفاده کنند.
- متدهایی که ممکن است با شکست مواجه شوند، باید مقدار بازگشتی <code dir="ltr">boolean</code> داشته باشند.

---

## نمونه‌ی استفاده

<pre dir="ltr"><code>Client client = new Client(2001, "Sara");
Equipment equipment = new Equipment("EQ100", "Tennis Racket");

EquipmentRentalSystem system = new EquipmentRentalSystem();
system.addClient(client);
system.addEquipment(equipment);

RentAgreement rentAgreement = new RentAgreement(
    new Date(),
    new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000),
    300.0
);

system.rentEquipmentToClient(2001, "EQ100", rentAgreement);
system.returnEquipmentFromClient(2001, "EQ100");</code></pre>



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