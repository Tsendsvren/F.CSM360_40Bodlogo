### Бодлого №7

## Encryption

Өгөгдсөн мессежийг дараах алхмуудаар шифрлэнэ:

Сансрыг хасах: Мессежээс бүх зайг (space) хасах

Грид үүсгэх:

L нь мессежийн урт гэвэл floor(sqrt(L)) <= row <= column <= ceil(sqrt(L)) ба row * column >= L байх хамгийн бага row ба column-г олох

Мессежийг row мөр, column баганатай grid-д дүүргэх (зүүнээс баруун, дээрээс доош)

Шифрлэх: Grid-ийг баганаар уншиж, шифрлэгдсэн мессежийг гаргах (багана бүрийн тэмдэгтүүдийг зайгаар тусгаарлан)

Оролт

Нэг мөрөнд зай агуулаагүй мессеж (зөвхөн жижиг үсэг, тоо)

Гаралт

Шифрлэгдсэн мессеж

Жишээ

Оролт:

haveaniceday

Гаралт:

hae and via ecy

Тайлбар:

Сансар хасагдаад haveaniceday (урт L=12)

sqrt(12) ≈ 3.464 → row=3, column=4 (3*4=12 ≥ 12)

Grid:

h a v e

a n i c

e d a y

Баганаар уншихад:

1-р багана: h, a, e → "hae"

2-р багана: a, n, d → "and"

3-р багана: v, i, a → "via"

4-р багана: e, c, y → "ecy"

Шифр: "hae and via ecy"

Бодолт

Сансар хасах: message.replaceAll(" ", "")

Grid хэмжээ олох:

L = message.length()

row = floor(sqrt(L)), column = ceil(sqrt(L))

Хэрэв row * column < L бол row-г нэмэгдүүлэх

Grid дүүргэх:

Мөр болгонд column тэмдэгт байхаар хуваах

Шифрлэх:

Багана бүрээс тэмдэгтүүдийг цуглуулж, зайгаар тусгаарлах

<p align="center">
  <img src="../image/Bodlogo7.1.png" alt="Bodlogo7.1" width="100%"/>
</p>

<p align="center">
  <img src="../image/Bodlogo7.2.png" alt="Bodlogo7.2" width="100%"/>
</p>


---

✅ **ТАЙЛАН ДУУСАВ!**
