<div dir="rtl" align="right">

# کنترل سطح دسترسی

# طراحی کلاس <code dir="ltr">SecureDocumentVault</code> با کنترل داخلی سطح دسترسی

## مقدمه

در بسیاری از سیستم‌های نرم‌افزاری، اطلاعات مهم نباید در اختیار همه کاربران قرار بگیرند.

برای مثال، در یک سامانه ذخیره‌سازی اسناد، ممکن است فقط کاربران مجاز بتوانند اطلاعاتی مانند تعداد اسناد، میزان فضای مصرف‌شده یا عملیات حذف اسناد را مشاهده و مدیریت کنند.

در چنین شرایطی، استفاده از اصل <b>کپسوله‌سازی</b> یا <code dir="ltr">Encapsulation</code> اهمیت زیادی دارد؛ زیرا داده‌های حساس نباید مستقیماً در اختیار بیرون کلاس قرار بگیرند.

همچنین منطق کنترل دسترسی باید داخل خود کلاس پیاده‌سازی شود، نه اینکه کلاس‌های دیگر تصمیم بگیرند چه کسی مجاز است و چه کسی نیست.

---

## هدف

طراحی کلاسی به نام <code dir="ltr">SecureDocumentVault</code> که نمایانگر یک فضای امن برای نگهداری اسناد باشد.

این کلاس باید دسترسی به اطلاعات و عملیات خود را فقط بر اساس سطح دسترسی کاربر کنترل کند.

---

## مشخصات کلاس

کلاس <code dir="ltr">SecureDocumentVault</code> باید دارای فیلدهای زیر باشد:

### فیلدها

| نام فیلد | نوع داده | توضیح |
|---|---|---|
| <code dir="ltr">ownerName</code> | <code dir="ltr">String</code> | نام مالک فضای اسناد |
| <code dir="ltr">documentCount</code> | <code dir="ltr">int</code> | تعداد اسناد ذخیره‌شده |
| <code dir="ltr">storageUsed</code> | <code dir="ltr">double</code> | میزان فضای مصرف‌شده بر حسب مگابایت |
| <code dir="ltr">accessLevel</code> | <code dir="ltr">AccessLevel</code> | سطح دسترسی کاربر |

---

## سطح‌های دسترسی

یک <code dir="ltr">enum</code> به نام <code dir="ltr">AccessLevel</code> باید با مقادیر زیر تعریف شود:

<pre dir="ltr"><code>ADMIN
USER
GUEST</code></pre>

---

## اصول طراحی

### ۱. کپسوله‌سازی کامل

تمام فیلدهای کلاس باید <code dir="ltr">private</code> باشند.

هیچ فیلدی نباید مستقیماً از بیرون کلاس قابل دسترسی باشد.

دسترسی به داده‌ها فقط باید از طریق متدهای عمومی و کنترل‌شده انجام شود.

---

### ۲. کنترل داخلی سطح دسترسی

منطق بررسی سطح دسترسی باید داخل کلاس <code dir="ltr">SecureDocumentVault</code> پیاده‌سازی شود.

یعنی کلاس‌های دیگر نباید قبل از صدا زدن متدها بررسی کنند که کاربر مجاز است یا نه.

---

## متدهای مورد نیاز

### متد <code dir="ltr">viewVaultInfo</code>

این متد اطلاعات فضای اسناد را نمایش می‌دهد.

قوانین دسترسی:

- کاربران با سطح دسترسی <code dir="ltr">ADMIN</code> مجاز به مشاهده اطلاعات هستند.
- کاربران با سطح دسترسی <code dir="ltr">USER</code> مجاز به مشاهده اطلاعات هستند.
- کاربران با سطح دسترسی <code dir="ltr">GUEST</code> مجاز به مشاهده اطلاعات نیستند.

در صورت عدم دسترسی، خروجی باید برابر باشد با:

<pre dir="ltr"><code>"Access Denied"</code></pre>

خروجی در حالت مجاز باید به شکل زیر باشد:

<pre dir="ltr"><code>"Vault Info: 10 documents, 250.0MB used"</code></pre>

---

### متد <code dir="ltr">addDocument</code>

این متد یک سند جدید به فضای اسناد اضافه می‌کند.

قوانین دسترسی:

- کاربران با سطح دسترسی <code dir="ltr">ADMIN</code> مجاز به افزودن سند هستند.
- کاربران با سطح دسترسی <code dir="ltr">USER</code> مجاز به افزودن سند هستند.
- کاربران با سطح دسترسی <code dir="ltr">GUEST</code> مجاز به افزودن سند نیستند.

اگر اندازه سند صفر یا منفی باشد، خروجی باید برابر باشد با:

<pre dir="ltr"><code>"Invalid document size"</code></pre>

در صورت موفقیت:

- تعداد اسناد یک واحد افزایش پیدا می‌کند.
- میزان فضای مصرف‌شده به اندازه سند جدید افزایش پیدا می‌کند.

خروجی موفق باید به شکل زیر باشد:

<pre dir="ltr"><code>"Document added. Storage Used: 300.0MB"</code></pre>

---

### متد <code dir="ltr">removeDocument</code>

این متد یک سند را از فضای اسناد حذف می‌کند.

قوانین دسترسی:

- فقط کاربران با سطح دسترسی <code dir="ltr">ADMIN</code> مجاز به حذف سند هستند.
- کاربران با سطح دسترسی <code dir="ltr">USER</code> مجاز به حذف سند نیستند.
- کاربران با سطح دسترسی <code dir="ltr">GUEST</code> مجاز به حذف سند نیستند.

اگر اندازه سند صفر یا منفی باشد، خروجی باید برابر باشد با:

<pre dir="ltr"><code>"Invalid document size"</code></pre>

اگر اندازه حذف‌شده بیشتر از فضای مصرف‌شده باشد، خروجی باید برابر باشد با:

<pre dir="ltr"><code>"Invalid removal amount"</code></pre>

در صورت موفقیت:

- تعداد اسناد یک واحد کاهش پیدا می‌کند.
- میزان فضای مصرف‌شده کاهش پیدا می‌کند.

خروجی موفق باید به شکل زیر باشد:

<pre dir="ltr"><code>"Document removed. Storage Used: 150.0MB"</code></pre>

---

## نکته مهم

کنترل سطح دسترسی نباید در بیرون کلاس انجام شود.

تمام تصمیم‌گیری‌ها درباره مجاز یا غیرمجاز بودن عملیات باید داخل کلاس <code dir="ltr">SecureDocumentVault</code> پیاده‌سازی شود.



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