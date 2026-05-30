<div dir="rtl" align="right">

# ترموستات هوشمند

# طراحی کلاس <code dir="ltr">SmartThermostat</code> با کنترل دما و حالت کاری

## اهداف تمرین

در این تمرین، هدف آشنایی با مفاهیم مقدماتی شی‌گرایی در زبان جاوا است.

دانشجو باید بتواند:

- فیلدهای کلاس را به‌صورت <code dir="ltr">private</code> تعریف کند.
- برای دسترسی به فیلدها از <code dir="ltr">getter</code> و <code dir="ltr">setter</code> استفاده کند.
- از <code dir="ltr">enum</code> برای تعیین حالت کاری دستگاه استفاده کند.
- مقدار دما را در یک بازه مجاز کنترل کند.
- روشن یا خاموش بودن دستگاه را مدیریت کند.
- بر اساس وضعیت دستگاه، پیام مناسب تولید کند.

---

## هدف

طراحی کلاسی به نام <code dir="ltr">SmartThermostat</code> که نمایانگر یک ترموستات هوشمند باشد.

این ترموستات می‌تواند روشن یا خاموش باشد، حالت کاری مختلف داشته باشد و دمای تنظیم‌شده آن فقط در یک بازه مجاز قرار بگیرد.

---

## مشخصات کلاس

### ۱. تعریف <code dir="ltr">enum</code>

یک <code dir="ltr">enum</code> به نام <code dir="ltr">ThermostatMode</code> با مقادیر زیر تعریف کنید:

<pre dir="ltr"><code>COOL
HEAT
FAN
AUTO</code></pre>

---

### ۲. کلاس <code dir="ltr">SmartThermostat</code>

کلاس <code dir="ltr">SmartThermostat</code> باید دارای فیلدهای خصوصی زیر باشد:

| نام فیلد | نوع داده | توضیح |
|---|---|---|
| <code dir="ltr">mode</code> | <code dir="ltr">ThermostatMode</code> | حالت کاری ترموستات |
| <code dir="ltr">temperature</code> | <code dir="ltr">int</code> | دمای تنظیم‌شده |
| <code dir="ltr">isOn</code> | <code dir="ltr">boolean</code> | وضعیت روشن یا خاموش بودن دستگاه |

---

## مقدارهای پیش‌فرض

در سازنده بدون ورودی کلاس، مقدارهای اولیه باید به شکل زیر باشند:

| فیلد | مقدار پیش‌فرض |
|---|---|
| <code dir="ltr">mode</code> | <code dir="ltr">AUTO</code> |
| <code dir="ltr">temperature</code> | <code dir="ltr">22</code> |
| <code dir="ltr">isOn</code> | <code dir="ltr">false</code> |

---

## متدهای مورد نیاز

کلاس <code dir="ltr">SmartThermostat</code> باید متدهای زیر را داشته باشد:

| نام متد | توضیح |
|---|---|
| <code dir="ltr">turnOn()</code> | روشن کردن ترموستات |
| <code dir="ltr">turnOff()</code> | خاموش کردن ترموستات |
| <code dir="ltr">setMode(ThermostatMode mode)</code> | تنظیم حالت کاری |
| <code dir="ltr">getMode()</code> | دریافت حالت کاری |
| <code dir="ltr">setTemperature(int temperature)</code> | تنظیم دما |
| <code dir="ltr">getTemperature()</code> | دریافت دمای تنظیم‌شده |
| <code dir="ltr">isOn()</code> | بررسی روشن بودن دستگاه |
| <code dir="ltr">getStatusMessage()</code> | تولید پیام وضعیت ترموستات |

---

## محدودیت دما

دمای ترموستات باید فقط در بازه ۱۶ تا ۳۰ درجه قرار بگیرد.

قوانین تنظیم دما:

- اگر مقدار ورودی کمتر از ۱۶ باشد، دما باید برابر ۱۶ قرار بگیرد.
- اگر مقدار ورودی بیشتر از ۳۰ باشد، دما باید برابر ۳۰ قرار بگیرد.
- در غیر این صورت، همان مقدار ورودی ذخیره شود.

---

## منطق متد <code dir="ltr">getStatusMessage</code>

این متد باید بر اساس وضعیت دستگاه و دمای تنظیم‌شده، پیام مناسب برگرداند.

| وضعیت دستگاه | دما | پیام بازگشتی |
|---|---|---|
| خاموش | هر مقدار | <code dir="ltr">"Thermostat is OFF"</code> |
| روشن | کمتر از ۲۰ | <code dir="ltr">"Mode: [MODE], temperature is cool"</code> |
| روشن | بین ۲۰ تا ۲۴ | <code dir="ltr">"Mode: [MODE], temperature is comfortable"</code> |
| روشن | بیشتر از ۲۴ | <code dir="ltr">"Mode: [MODE], temperature is warm"</code> |

---

## مثال استفاده

<pre dir="ltr"><code>SmartThermostat thermostat = new SmartThermostat();

thermostat.turnOn();
thermostat.setMode(ThermostatMode.COOL);
thermostat.setTemperature(18);

System.out.println(thermostat.getStatusMessage());
// Mode: COOL, temperature is cool

thermostat.setTemperature(22);

System.out.println(thermostat.getStatusMessage());
// Mode: COOL, temperature is comfortable

thermostat.turnOff();

System.out.println(thermostat.getStatusMessage());
// Thermostat is OFF</code></pre>


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