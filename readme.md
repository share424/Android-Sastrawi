<h1 align="center">Android Sastrawi</h1>
<p align="center">
  <a href="https://jitpack.io/#share424/Android-Sastrawi"><img src="https://jitpack.io/v/share424/Android-Sastrawi.svg"/></a>
  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg"/></a>
  <br /><br />
Android Sastrawi is a Natural Language Processing Toolkit for Bahasa Indonesia. It is port from original <a href="https://github.com/sastrawi/sastrawi">Sastrawi</a> project.
</p>


# Instalasi
Tambahkan repository jitpack pada file gradle anda
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Selanjutnya tambahkan depedency
```
implementation 'com.github.share424:Android-Sastrawi:1.0.0'
```
# Fitur
## Stemming
### Apa itu Stemming?
[Stemming](https://en.wikipedia.org/wiki/Stemming) adalah proses mengubah kata yang berimbuhan menjadi kata dasar. 

Contohnya
```
berlari => lari
mengandai-andaikan => andai
```
### Cara Penggunaan
Untuk membuat stemmer bisa menggunakan perintah berikut
```
val stemmer = StemmerFactory(context).create()
```
cara diatas akan menggunakan [kamus kata dasar bawaan](https://github.com/share424/Android-Sastrawi/raw/master/sastrawi/src/main/assets/kata_dasar.txt) dari (kateglo)[kateglo.com]

Selanjutnya kita bisa langsung melakukan stemming dengan method `stem()`, seperti berikut
```
val output = stemmer.stem("Perekonomian Indonesia sedang dalam pertumbuhan yang membanggakan")
// output = ekonomi indonesia sedang dalam tumbuh yang bangga
```
Jika ingin menggunakan kamus kata dasar sendiri, bisa menggunakan method `fromFile()` untuk dari file dan `fromList()` untuk dari `List<String>`. Contohnya seperti berikut
```
// kamus kata dasar dari file txt
// format file dipisah dengan enter tiap katanya
val file = File("path to file.txt")
val stemmerFromFile = StemmerFactory(context)
                            .fromFile(file)
                            .create()
                        
// kamus kata dasar dari List<string>
val list = listOf<String>("jalan", "tumbuh", "bangga")
val stemmerFromList = StemmerFactory(context)
                            .fromList(list)
                            .create()
```
<img src="https://github.com/share424/Android-Sastrawi/raw/master/images/stemmer.jpeg" alt="Stemmer" height="400" style="text-align:center" />

## Stop Word Remover
### Apa itu Stop Word?
[Stop Words](https://en.wikipedia.org/wiki/Stop_words) adalah kumpulan kata yang akan dihilangkan sebelum dilakukan proses NLP.

Contohnya
```
di, ke, yang, untuk, pada, ....
```
### Penggunaan
Untuk membuat Stop Word Remover bisa menggunakan perintah berikut
```
val stopWordRemover = StopWordRemoverFactory(context).create()
```
cara diatas akan menggunakan [kamus stop word bawaan](https://github.com/share424/Android-Sastrawi/raw/master/sastrawi/src/main/assets/stop_words.txt).

Selanjutnya kita bisa menghilangkan stopword dengan method `remove()`, seperti berikut
```
val output = stopWordRemover.remove("Perekonomian Indonesia sedang dalam pertumbuhan yang membanggakan")
// output = perekonomian indonesia sedang pertumbuhan membanggakan
```
Jika ingin menggunakan kamus stop words sendiri, bisa menggunakan method `fromFile()` untuk dari file dan `fromList()` untuk dari `List<String>`. Contohnya seperti berikut
```
// kamus stop words dari file txt
// format file dipisah dengan enter tiap katanya
val file = File("path to file.txt")
val stopWordRemoverFromFile = StopWordRemoverFactory(context)
                                      .fromFile(file)
                                      .create()
// kamus stop words dari List<string>
val list = listOf<String>("di", "ke", "yang")
val stopWordRemoverFromList = StopWordRemoverFactory(context)
                                      .fromList(list)
                                      .create()
```
<img src="https://github.com/share424/Android-Sastrawi/raw/master/images/stop_word.jpeg" alt="Stop Word remover" height="400" style="text-align:center" />
# Pustaka
## Algoritma
Algoritma yang digunakan pada library ini adalah hak intelektual masing-masing pemiliknya yang tertera di bawah ini. Lalu untuk meningkatkan kualitas kode, algoritma tersebut diterapkan ke dalam Object Oriented Design.
- Algoritma Nazief dan Adriani
- Asian J. 2007. Effective Techniques for Indonesian Text Retrieval. PhD thesis School of Computer Science and Information Technology RMIT University Australia
- Arifin, A.Z., I.P.A.K. Mahendra dan H.T. Ciptaningtyas. 2009. Enhanced Confix Stripping Stemmer and Ants Algorithm for Classifying News Document in Indonesian Language, Proceeding of International Conference on Information & Communication Technology and Systems (ICTS)
- A. D. Tahitoe, D. Purwitasari. 2010. Implementasi Modifikasi Enhanced Confix Stripping Stemmer Untuk Bahasa Indonesia dengan Metode Corpus Based Stemming, Institut Teknologi Sepuluh Nopember (ITS) – Surabaya, 60111, Indonesia
## Kamus Kata Dasar
Proses stemming oleh Sastrawi sangat bergantung pada kamus kata dasar. Sastrawi menggunakan kamus kata dasar dari [kateglo.com](http://kateglo.com) dengan sedikit perubahan.
# Lisensi
Lisensi sastrawi adalah [MIT](http://choosealicense.com/licenses/mit/) License (MIT) sedangkan lisensi kamus kata dasar dari Kateglo adalah [CC-BY-NC-SA 3.0](https://github.com/ivanlanin/kateglo#lisensi-isi).
# Di Bahasa Pemrograman Lainya
- [Sastrawi](https://github.com/sastrawi/sastrawi) - PHP
- [JSastrawi](https://github.com/jsastrawi/jsastrawi) - Java
- [cSastrawi](https://github.com/mohangk/c_sastrawi) - C
- [PySastrawi](https://github.com/har07/PySastrawi) - Python
- [Go-Sastrawi](https://github.com/RadhiFadlillah/go-sastrawi) - Go
- [Sastrawi-Ruby](https://github.com/meisyal/sastrawi-ruby) - Ruby
- [SastrawiJs](https://github.com/damzaky/sastrawijs) - Javascript
