package com.example.mykonstitutsiyasi

import android.app.Fragment
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.fragment.findNavController

import com.example.mykonstitutsiyasi.adapter.AdapterRv

import com.example.mykonstitutsiyasi.databinding.FragmentAllBinding
import com.example.mykonstitutsiyasi.dp.AppDatabase
import com.example.mykonstitutsiyasi.model.Category
import com.example.mykonstitutsiyasi.model.Chap
import com.example.mykonstitutsiyasi.model.Department
import com.example.mykonstitutsiyasi.model.Substance


class AllFragment : androidx.fragment.app.Fragment() {
    lateinit var binding:FragmentAllBinding
    lateinit var adapter: AdapterRv
    lateinit var listWord:HashMap<String,ArrayList<Category>>
    lateinit var list:ArrayList<Department>

    lateinit var appDatabase: AppDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_all, container, false)
        binding= FragmentAllBinding.bind(view)
        init()
        adapter= AdapterRv(object :AdapterRv.itemClick{
            override fun root(department: Department, position: Int) {
                val bundle=Bundle()
                bundle.putSerializable("name",department)
                findNavController().navigate(R.id.action_allFragment_to_infoFragment,bundle)
            }

        })
        adapter.submitList(list)

        binding.rv.adapter=adapter

        binding.leftAll.setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }

    private fun init() {
        list= ArrayList()

        val chap=ArrayList<Chap>()
        val substance=ArrayList<Substance>()

        substance.add(Substance("1-modda","O‘zbekiston — boshqaruvning respublika shakliga ega bo‘lgan suveren, demokratik, huquqiy, ijtimoiy va dunyoviy davlat.Davlatning “O‘zbekiston Respublikasi” va “O‘zbekiston” degan nomlari bir ma’noni anglatadi."))
        substance.add(Substance("2-modda","Davlat xalq irodasini ifoda etib, uning manfaatlariga xizmat qiladi. Davlat organlari va mansabdor shaxslar jamiyat va fuqarolar oldida mas’uldirlar."))
        substance.add(Substance("3-modda","O‘zbekiston Respublikasi o‘zining milliy-davlat va ma’muriy-hududiy tuzilishini, davlat hokimiyati organlarining tizimini belgilaydi, ichki va tashqi siyosatini amalga oshiradi. O‘zbekistonning davlat chegarasi va hududi daxlsiz va bo‘linmasdir."))
        substance.add(Substance("4-modda","O‘zbekiston Respublikasining davlat tili o‘zbek tilidir.O‘zbekiston Respublikasi o‘z hududida istiqomat qiluvchi millat va elatlarning tillari, urf-odatlari va an’analari hurmat qilinishini ta’minlaydi, ularning rivojlanishi uchun sharoit yaratadi."))
        substance.add(Substance("5-modda","O‘zbekiston Respublikasi qonun bilan tasdiqlanadigan o‘z davlat ramzlari — bayrog‘i, gerbi va madhiyasiga ega. Davlat ramzlari davlat himoyasidadir."))
        substance.add(Substance("6-modda","O‘zbekiston Respublikasining poytaxti — Toshkent shahri"))

        chap.add(Chap("I bob. Davlat suvereniteti",substance))

        val substance2=ArrayList<Substance>()
        substance2.add(Substance("7-modda","Xalq davlat hokimiyatining birdan-bir manbaidir. O‘zbekiston Respublikasida davlat hokimiyati xalq manfaatlarini ko‘zlab va O‘zbekiston Respublikasi Konstitutsiyasi hamda uning asosida qabul qilingan qonunlar vakolat bergan organlar tomonidangina amalga oshiriladi. Konstitutsiyada nazarda tutilmagan tartibda davlat hokimiyati vakolatlarini o‘zlashtirish, hokimiyat organlari faoliyatini to‘xtatib qo‘yish yoki tugatish, hokimiyatning yangi va muvoziy tarkiblarini tuzish Konstitutsiyaga xilof hisoblanadi va qonunga binoan javobgarlikka tortishga asos bo‘ladi."))
        substance2.add(Substance("8-modda","O‘zbekiston xalqini millatidan qat’i nazar, O‘zbekiston Respublikasining fuqarolari tashkil etadi."))
        substance2.add(Substance("9-modda","Jamiyat va davlat hayotining eng muhim masalalari xalq muhokamasiga taqdim etiladi, umumxalq ovoziga — referendumga qo‘yiladi. O‘zbekiston Respublikasida referendum o‘tkazish tartibi qonun bilan belgilanadi."))
        substance2.add(Substance("10-modda","O‘zbekiston xalqi nomidan faqat u saylagan O‘zbekiston Respublikasi Oliy Majlisi va Prezidenti ish olib borishi mumkin. Jamiyatning biron-bir qismi, siyosiy partiya, jamoat birlashmasi, ijtimoiy harakat yoki alohida shaxs O‘zbekiston xalqi nomidan ish olib borishga haqli emas."))
        substance2.add(Substance("11-modda","O‘zbekiston Respublikasi davlat hokimiyatining tizimi — hokimiyatning qonun chiqaruvchi, ijro etuvchi va sud hokimiyatiga bo‘linishi prinsipiga asoslanadi."))
        substance2.add(Substance("12-modda","O‘zbekiston Respublikasida ijtimoiy hayot siyosiy institutlar, mafkuralar va fikrlarning xilma-xilligi asosida rivojlanadi. Hech qaysi mafkura davlat mafkurasi sifatida o‘rnatilishi mumkin emas."))
        substance2.add(Substance("13-modda","O‘zbekiston Respublikasida demokratiya umuminsoniy prinsiplarga asoslanadi, ularga ko‘ra inson, uning hayoti, erkinligi, sha’ni, qadr-qimmati va boshqa ajralmas huquqlari oliy qadriyat hisoblanadi. Demokratik huquq va erkinliklar Konstitutsiya va qonunlar bilan himoya qilinadi."))
        substance2.add(Substance("14-modda","Davlat o‘z faoliyatini inson farovonligini va jamiyatning barqaror rivojlanishini ta’minlash maqsadida qonuniylik, ijtimoiy adolat va birdamlik prinsiplari asosida amalga oshiradi."))
        chap.add(Chap("II bob. Xalq hokimiyatchiligi",substance2))


        val substance3=ArrayList<Substance>()
        substance3.add(Substance("15-modda","O‘zbekiston Respublikasida O‘zbekiston Respublikasi Konstitutsiyasi va qonunlarining ustunligi so‘zsiz tan olinadi. O‘zbekiston Respublikasi Konstitutsiyasi mamlakatning butun hududida oliy yuridik kuchga ega, to‘g‘ridan to‘g‘ri amal qiladi va yagona huquqiy makonning asosini tashkil etadi. O‘zbekiston Respublikasining xalqaro shartnomalari xalqaro huquqning umume’tirof etilgan prinsip va normalari bilan bir qatorda O‘zbekiston Respublikasi huquqiy tizimining tarkibiy qismidir. Agar O‘zbekiston Respublikasining xalqaro shartnomasida O‘zbekiston Respublikasining qonunida nazarda tutilganidan boshqacha qoidalar belgilangan bo‘lsa, O‘zbekiston Respublikasining xalqaro shartnomasi qoidalari qo‘llaniladi. Davlat va uning organlari, boshqa tashkilotlar, mansabdor shaxslar, fuqarolik jamiyati institutlari hamda fuqarolar Konstitutsiya va qonunlarga muvofiq ish yuritadilar."))
        substance3.add(Substance("16-modda","Ushbu Konstitutsiyaning birorta qoidasi O‘zbekiston Respublikasining huquq va manfaatlariga, ushbu Konstitutsiyaning birinchi bo‘limida nazarda tutilgan asosiy prinsip va normalarga zarar yetkazadigan tarzda talqin etilishi mumkin emas. O‘zbekiston Respublikasining qonunlari va boshqa normativ-huquqiy hujjatlari O‘zbekiston Respublikasining Konstitutsiyasi asosida va uni ijro etish yuzasidan qabul qilinadi. Birorta qonun yoki boshqa normativ-huquqiy hujjat Konstitutsiyaning prinsip va normalariga zid bo‘lishi mumkin emas."))
        chap.add(Chap("III bob. Konstitutsiya va qonunning ustunligi",substance3))

        val substance4=ArrayList<Substance>()
        substance4.add(Substance("17-modda","O‘zbekiston Respublikasi xalqaro munosabatlarning to‘la huquqli subyektidir. O‘zbekistonning tashqi siyosati davlatlarning suveren tengligi, kuch ishlatmaslik yoki kuch bilan tahdid qilmaslik, chegaralarning buzilmasligi, davlatlarning hududiy yaxlitligi, nizolarni tinch yo‘l bilan hal etish, boshqa davlatlarning ichki ishlariga aralashmaslik prinsiplariga hamda xalqaro huquqning umume’tirof etilgan boshqa prinsip va normalariga asoslanadi."))
        substance4.add(Substance("18-modda","O‘zbekiston Respublikasi davlatlar va xalqaro tashkilotlar bilan ikki va ko‘p tomonlama munosabatlarni har taraflama rivojlantirishga qaratilgan tinchliksevar tashqi siyosatni amalga oshiradi. O‘zbekiston Respublikasi davlatning, xalqning oliy manfaatlaridan, uning farovonligi va xavfsizligidan kelib chiqqan holda ittifoqlar tuzishi, hamdo‘stliklarga va boshqa davlatlararo tuzilmalarga kirishi hamda ulardan chiqishi mumkin."))

        chap.add(Chap("IV bob. Tashqi siyosat",substance4))

        list.add(Department("BIRINChI BO‘LIM. ASOSIY PRINSIPLAR",chap))


        val chap2=ArrayList<Chap>()
        val substance5=ArrayList<Substance>()
        substance5.add(Substance("19-modda",
            "O‘zbekiston Respublikasida insonning huquq va erkinliklari xalqaro huquqning umume’tirof etilgan normalariga binoan hamda ushbu Konstitutsiyaga muvofiq e’tirof etiladi va kafolatlanadi. Inson huquq va erkinliklari har kimga tug‘ilganidan boshlab tegishli bo‘ladi. O‘zbekiston Respublikasida barcha fuqarolar bir xil huquq va erkinliklarga ega bo‘lib, jinsi, irqi, millati, tili, dini, e’tiqodi, ijtimoiy kelib chiqishi, ijtimoiy mavqeyidan qat’i nazar, qonun oldida tengdirlar. Imtiyozlar faqat qonunga muvofiq belgilanadi va ijtimoiy adolat prinsiplariga mos bo‘lishi shart."))


        substance5.add(Substance("20-modda","O‘zbekiston Respublikasi fuqarosi va davlat bir-biriga nisbatan o‘zaro huquq va majburiyatlar bilan bog‘liqdir.\n" +
                "Insonning Konstitutsiya va qonunlarda mustahkamlab qo‘yilgan huquq va erkinliklari daxlsizdir hamda ulardan sud qarorisiz mahrum etishga yoki ularni cheklab qo‘yishga hech kim haqli emas.\n" +
                "Insonning huquq va erkinliklari bevosita amal qiladi. Insonning huquq va erkinliklari qonunlarning, davlat organlari, fuqarolarning o‘zini o‘zi boshqarish organlari, ularning mansabdor shaxslari faoliyatining mohiyati va mazmunini belgilaydi.\n" +
                "Davlat organlari tomonidan insonga nisbatan qo‘llaniladigan huquqiy ta’sir choralari mutanosiblik prinsipiga asoslanishi va qonunlarda nazarda tutilgan maqsadlarga erishish uchun yetarli bo‘lishi kerak.\n" +
                "Inson bilan davlat organlarining o‘zaro munosabatlarida yuzaga keladigan qonunchilikdagi barcha ziddiyatlar va noaniqliklar inson foydasiga talqin etiladi."))


        substance5.add(
            Substance(
                "21-modda",
                "Har bir inson o‘z shaxsini erkin kamol toptirish huquqiga ega. Hech kimga uning roziligisiz qonunchilikda belgilanmagan majburiyat yuklatilishi mumkin emas.\n" +
                        "Inson o‘z huquq va erkinliklarini amalga oshirishda boshqa shaxslarning, jamiyat hamda davlatning huquqlari, erkinliklari va qonuniy manfaatlariga putur yetkazmasligi shart.\n" +
                        "Insonning huquq va erkinliklari faqat qonunga muvofiq va faqat konstitutsiyaviy tuzumni, aholining sog‘lig‘ini, ijtimoiy axloqni, boshqa shaxslarning huquq va erkinliklarini himoya qilish, jamoat xavfsizligini hamda jamoat tartibini ta’minlash maqsadida zarur bo‘lgan doirada cheklanishi mumkin.")
        )


        chap2.add(Chap("V bob. Umumiy qoidalar",substance5))

        val substance6=ArrayList<Substance>()
        substance6.add(Substance("22-modda","O‘zbekiston Respublikasining butun hududida yagona fuqarolik o‘rnatiladi.\n" +
                "O‘zbekiston Respublikasining fuqaroligi, unga qanday asoslarda ega bo‘lganlikdan qat’i nazar, hamma uchun tengdir.\n" +
                "Qoraqalpog‘iston Respublikasining fuqarosi ayni vaqtda O‘zbekiston Respublikasining fuqarosi hisoblanadi.\n" +
                "Fuqarolikka ega bo‘lish va uni yo‘qotish asoslari hamda tartibi qonun bilan belgilanadi."))

        substance6.add(Substance("23-modda","O‘zbekiston Respublikasi o‘z hududida ham, uning tashqarisida ham o‘z fuqarolarini himoya qilish va ularga homiylik ko‘rsatishni kafolatlaydi.\n" +
                "O‘zbekiston Respublikasi fuqarosi O‘zbekistondan tashqariga majburiy chiqarib yuborilishi yoki boshqa davlatga berib yuborilishi mumkin emas.\n" +
                "Davlat xorijda yashayotgan vatandoshlar bilan aloqalarni saqlab qolish hamda rivojlantirish to‘g‘risida xalqaro huquq normalariga muvofiq g‘amxo‘rlik qiladi."))

        substance6.add(Substance("24-modda","O‘zbekiston Respublikasi hududidagi chet el fuqarolarining va fuqaroligi bo‘lmagan shaxslarning huquq va erkinliklari xalqaro huquq normalariga muvofiq ta’minlanadi. Ular O‘zbekiston Respublikasining Konstitutsiyasi, qonunlari va xalqaro shartnomalari bilan belgilangan burchlarni ado etadilar."))

        chap2.add(Chap("VI bob. Fuqarolik",substance6))

        val substance7=ArrayList<Substance>()

        substance7.add(Substance("25-modda","Yashash huquqi har bir insonning ajralmas huquqidir va u qonun bilan muhofaza qilinadi. Inson hayotiga suiqasd qilish eng og‘ir jinoyatdir.\n" +
                "O‘zbekiston Respublikasida o‘lim jazosi taqiqlanadi."))

        substance7.add(Substance("26-modda","Insonning sha’ni va qadr-qimmati daxlsizdir. Hech narsa ularni kamsitish uchun asos bo‘lishi mumkin emas.\n" +
                "Hech kim qiynoqqa solinishi, zo‘ravonlikka, boshqa shafqatsiz, g‘ayriinsoniy yoki inson qadr-qimmatini kamsituvchi muomalaga yoxud jazoga duchor etilishi mumkin emas.\n" +
                "Hech kimda uning roziligisiz tibbiy va ilmiy tajribalar o‘tkazilishi mumkin emas."))

        substance7.add(Substance("27-modda","Har kim erkinlik va shaxsiy daxlsizlik huquqiga ega.\n" +
                "Hech kim qonunga asoslanmagan holda hibsga olinishi, ushlab turilishi, qamoqqa olinishi, qamoqda saqlanishi yoki uning ozodligi boshqacha tarzda cheklanishi mumkin emas.\n" +
                "Hibsga olishga, qamoqqa olishga va qamoqda saqlashga faqat sudning qaroriga ko‘ra yo‘l qo‘yiladi. Shaxs sudning qarorisiz qirq sakkiz soatdan ortiq muddat ushlab turilishi mumkin emas.\n" +
                "Shaxsni ushlash chog‘ida unga tushunarli tilda uning huquqlari va ushlab turilishi asoslari tushuntirilishi shart."))

        substance7.add(Substance("28-modda","Jinoyat sodir etganlikda ayblanayotgan shaxs uning aybi qonunda nazarda tutilgan tartibda oshkora sud muhokamasi yo‘li bilan isbotlanmaguncha va sudning qonuniy kuchga kirgan hukmi bilan aniqlanmaguncha aybsiz deb hisoblanadi. Ayblanuvchiga o‘zini himoya qilish uchun barcha imkoniyatlar ta’minlanadi.\n" +
                "Aybdorlikka oid barcha shubhalar, agar ularni bartaraf etish imkoniyatlari tugagan bo‘lsa, gumon qilinuvchining, ayblanuvchining, sudlanuvchining yoki mahkumning foydasiga hal qilinishi kerak.\n" +
                "Gumon qilinuvchi, ayblanuvchi yoki sudlanuvchi o‘zining aybsizligini isbotlashi shart emas va istalgan vaqtda sukut saqlash huquqidan foydalanishi mumkin.\n" +
                "Hech kim o‘ziga va yaqin qarindoshlariga qarshi guvohlik berishga majbur emas.\n" +
                "Agar shaxsning o‘z aybini tan olganligi unga qarshi yagona dalil bo‘lsa, u aybdor deb topilishi yoki jazoga tortilishi mumkin emas.\n" +
                "Ozodlikdan mahrum etilgan shaxslar o‘ziga nisbatan insoniy muomalada bo‘linishi hamda inson shaxsiga xos bo‘lgan sha’ni va qadr-qimmati hurmat qilinishi huquqiga ega.\n" +
                "Shaxsning sudlanganligi va bundan kelib chiqadigan huquqiy oqibatlar uning qarindoshlari huquqlarini cheklash uchun asos bo‘lishi mumkin emas."))

        substance7.add(
            Substance(
                "29-modda",
                "Har kimga malakali yuridik yordam olish huquqi kafolatlanadi. Qonunda nazarda tutilgan hollarda yuridik yordam davlat hisobidan ko‘rsatiladi.\n" +
                        "Har bir shaxs jinoyat protsessining har qanday bosqichida, shaxs ushlanganida esa uning harakatlanish erkinligi huquqi amalda cheklangan paytdan e’tiboran o‘z tanloviga ko‘ra advokat yordamidan foydalanish huquqiga ega.\n" +
                        "Gumon qilinuvchi, ayblanuvchi yoki sudlanuvchi ayblovning mohiyati va asoslari to‘g‘risida xabardor qilinish, unga qarshi yoki uning foydasiga guvohlik berayotgan shaxslarning so‘roq qilinishini talab etish, tarjimon yordamidan foydalanish huquqiga ega.\n" +
                        "Qonunni buzgan holda olingan dalillardan odil sudlovni amalga oshirish chog‘ida foydalanishga yo‘l qo‘yilmaydi.\n" +
                        "Jinoyat uchun hukm qilingan har kim qonunda belgilangan tartibda hukmning yuqori turuvchi sud tomonidan qayta ko‘rib chiqilishi huquqiga, shuningdek afv etish yoki jazoni yengillashtirish to‘g‘risida iltimos qilish huquqiga ega.\n" +
                        "Huquqbuzarliklardan jabrlanganlarning huquqlari qonun bilan muhofaza qilinadi. Davlat jabrlanganlarga himoyalanishni va odil sudlovdan foydalanishni ta’minlaydi, ularga yetkazilgan zararning o‘rni qoplanishi uchun shart-sharoitlar yaratadi.")
        )
        substance7.add(Substance("30-modda","Hech kim rasmiy e’lon qilinmagan qonun asosida hukm qilinishi, jazoga tortilishi, mol-mulkidan yoki biron-bir huquqidan mahrum etilishi mumkin emas.\n" +
                "Hech kim ayni bir jinoyat uchun takroran hukm qilinishi mumkin emas."))

        substance7.add(
            Substance(
                "31-modda",
                "Har bir inson shaxsiy hayotining daxlsizligi, shaxsiy va oilaviy sirga ega bo‘lish, o‘z sha’ni va qadr-qimmatini himoya qilish huquqiga ega.\n" +
                        "Har kim yozishmalari, telefon orqali so‘zlashuvlari, pochta, elektron va boshqa xabarlari sir saqlanishi huquqiga ega. Ushbu huquqning cheklanishiga faqat qonunga muvofiq va sudning qaroriga asosan yo‘l qo‘yiladi.\n" +
                        "Har kim o‘z shaxsiga doir ma’lumotlarning himoya qilinishi huquqiga, shuningdek noto‘g‘ri ma’lumotlarning tuzatilishini, o‘zi to‘g‘risida qonunga xilof yo‘l bilan to‘plangan yoki huquqiy asoslarga ega bo‘lmay qolgan ma’lumotlarning yo‘q qilinishini talab qilish huquqiga ega.\n" +
                        "Har kim uy-joy daxlsizligi huquqiga ega.\n" +
                        "Hech kim uy-joyga unda yashovchi shaxslarning xohishiga qarshi kirishi mumkin emas. Uy-joyga kirishga, shuningdek unda olib qo‘yishni va ko‘zdan kechirishni o‘tkazishga faqat qonunda nazarda tutilgan hollarda va tartibda yo‘l qo‘yiladi. Uy-joyda tintuv o‘tkazishga faqat qonunga muvofiq va sudning qaroriga asosan yo‘l qo‘yiladi.")
        )
        substance7.add(Substance("32-modda","Qonuniy asoslarda O‘zbekiston Respublikasi hududida bo‘lib turgan har kim mamlakat bo‘ylab erkin harakatlanish, turar va yashash joyini tanlash huquqiga ega, bundan qonunda belgilangan cheklovlar mustasno.\n" +
                "Har kim O‘zbekistondan tashqariga erkin chiqish huquqiga ega, bundan qonunda belgilangan cheklovlar mustasno. O‘zbekiston Respublikasi fuqarosi O‘zbekistonga to‘sqinliksiz qaytish huquqiga ega"))

        substance7.add(Substance("33-modda","Har kim fikrlash, so‘z va e’tiqod erkinligi huquqiga ega.\n" +
                "Har kim istalgan axborotni izlash, olish va tarqatish huquqiga ega.\n" +
                "Davlat Internet jahon axborot tarmog‘idan foydalanishni ta’minlash uchun shart-sharoitlar yaratadi.\n" +
                "Axborotni izlash, olish va tarqatishga bo‘lgan huquqni cheklashga faqat qonunga muvofiq hamda faqat konstitutsiyaviy tuzumni, aholining sog‘lig‘ini, ijtimoiy axloqni, boshqa shaxslarning huquq va erkinliklarini himoya qilish, jamoat xavfsizligini hamda jamoat tartibini ta’minlash, shuningdek davlat sirlari yoki qonun bilan qo‘riqlanadigan boshqa sir oshkor etilishining oldini olish maqsadida zarur bo‘lgan doirada yo‘l qo‘yiladi."))

        substance7.add(Substance("34-modda","Davlat organlari va tashkilotlari, fuqarolarning o‘zini o‘zi boshqarish organlari, ularning mansabdor shaxslari har kimga o‘z huquqlari hamda qonuniy manfaatlariga daxldor bo‘lgan hujjatlar, qarorlar va boshqa materiallar bilan tanishish imkoniyatini ta’minlashi shart."))

        substance7.add(Substance("35-modda","Hamma uchun vijdon erkinligi kafolatlanadi. Har kim xohlagan dinga e’tiqod qilish yoki hech qaysi dinga e’tiqod qilmaslik huquqiga ega. Diniy qarashlarni majburan singdirishga yo‘l qo‘yilmaydi."))

        chap2.add(Chap("VII bob. Shaxsiy huquq va erkinliklar",substance7))


        val substance8=ArrayList<Substance>()
        substance8.add(Substance("36-modda","O‘zbekiston Respublikasining fuqarolari jamiyat va davlat ishlarini boshqarishda bevosita hamda o‘z vakillari orqali ishtirok etish huquqiga ega. Bunday ishtirok etish o‘zini o‘zi boshqarish, referendumlar o‘tkazish va davlat organlarini demokratik tarzda shakllantirish, shuningdek davlat organlarining faoliyati ustidan jamoatchilik nazorati vositasida amalga oshiriladi.\n" +
                "Davlat organlarining faoliyati ustidan jamoatchilik nazoratini amalga oshirish tartibi qonun bilan belgilanadi"))

        substance8.add(Substance("37-modda","O‘zbekiston Respublikasining fuqarolari davlat xizmatiga kirishda teng huquqqa egadirlar.\n" +
                "Davlat xizmatini o‘tash bilan bog‘liq cheklovlar qonun bilan belgilanadi."))

        substance8.add(Substance("38-modda","Fuqarolar o‘z ijtimoiy faolliklarini O‘zbekiston Respublikasi qonunlariga muvofiq mitinglar, yig‘ilishlar va namoyishlar shaklida amalga oshirish huquqiga ega. Hokimiyat organlari faqat xavfsizlik nuqtai nazaridangina bunday tadbirlar o‘tkazilishini to‘xtatish yoki taqiqlash huquqiga ega."))

        substance8.add(Substance("39-modda","O‘zbekiston Respublikasi fuqarolari kasaba uyushmalariga, siyosiy partiyalarga va boshqa jamoat birlashmalariga uyushish, ommaviy harakatlarda ishtirok etish huquqiga egadirlar.\n" +
                "Siyosiy partiyalarda, jamoat birlashmalarida, ommaviy harakatlarda, shuningdek davlat hokimiyati vakillik organlarida ozchilikni tashkil etuvchi muxolifatchi shaxslarning huquqlari, erkinliklari va qadr-qimmatini hech kim kamsitishi mumkin emas."))

        substance8.add(Substance("40-modda","Har kim bevosita o‘zi va boshqalar bilan birgalikda davlat organlariga hamda tashkilotlariga, fuqarolarning o‘zini o‘zi boshqarish organlariga, mansabdor shaxslarga yoki xalq vakillariga arizalar, takliflar va shikoyatlar bilan murojaat qilish huquqiga ega.\n" +
                "Arizalar, takliflar va shikoyatlar qonunda belgilangan tartibda va muddatlarda ko‘rib chiqilishi shart."))

        chap2.add(Chap("VIII bob. Siyosiy huquqlar",substance8))


        val substance9=ArrayList<Substance>()

        substance9.add(Substance("41-modda","Har bir shaxs mulkdor bo‘lishga haqli.\n" +
                "Bank operatsiyalarining, omonatlarning va hisobvaraqlarning sir tutilishi, shuningdek meros huquqi qonun bilan kafolatlanadi."))

        substance9.add(Substance("42-modda","Har kim munosib mehnat qilish, kasb va faoliyat turini erkin tanlash, xavfsizlik va gigiyena talablariga javob beradigan qulay mehnat sharoitlarida ishlash, mehnati uchun hech qanday kamsitishlarsiz hamda mehnatga haq to‘lashning belgilangan eng kam miqdoridan kam bo‘lmagan tarzda adolatli haq olish, shuningdek ishsizlikdan qonunda belgilangan tartibda himoyalanish huquqiga ega.\n" +
                "Mehnatga haq to‘lashning eng kam miqdori insonning munosib turmush darajasini ta’minlash zarurati hisobga olingan holda belgilanadi.\n" +
                "Homiladorligi yoki bolasi borligi sababli ayollarni ishga qabul qilishni rad etish, ishdan bo‘shatish va ularning ish haqini kamaytirish taqiqlanadi."))

        substance9.add(Substance("43-modda","Davlat fuqarolarning bandligini ta’minlash, ularni ishsizlikdan himoya qilish, shuningdek kambag‘allikni qisqartirish choralarini ko‘radi.\n" +
                "Davlat fuqarolarning kasbiy tayyorgarligini va qayta tayyorlanishini tashkil etadi hamda rag‘batlantiradi."))

        substance9.add(Substance("44-modda","Sud qarori bilan tayinlangan jazoni ijro etish tartibidan yoxud qonunda nazarda tutilgan boshqa hollardan tashqari majburiy mehnat taqiqlanadi.\n" +
                "Bolalar mehnatining bolaning sog‘lig‘iga, xavfsizligiga, axloqiga, aqliy va jismoniy rivojlanishiga xavf soluvchi, shu jumladan uning ta’lim olishiga to‘sqinlik qiluvchi har qanday shakllari taqiqlanadi."))

        substance9.add(Substance("45-modda","Har kim dam olish huquqiga ega.\n" +
                "Yollanib ishlovchilarga dam olish huquqi ish vaqtining davomiyligini, dam olish va ishlanmaydigan bayram kunlarini, haq to‘lanadigan har yilgi mehnat ta’tilini belgilash orqali ta’minlanadi."))

        substance9.add(Substance("46-modda","Har kim qariganda, mehnat qobiliyatini yo‘qotganda, ishsizlikda, shuningdek boquvchisini yo‘qotganda va qonunda nazarda tutilgan boshqa hollarda ijtimoiy ta’minot huquqiga ega.\n" +
                "Qonunda belgilangan pensiyalar, nafaqalar va boshqa turdagi ijtimoiy yordamning miqdorlari rasman belgilangan eng kam iste’mol xarajatlaridan oz bo‘lishi mumkin emas."))

        substance9.add(Substance("47-modda","Har kim uy-joyli bo‘lish huquqiga ega.\n" +
                "Hech kim sudning qarorisiz va qonunga zid tarzda uy-joyidan mahrum etilishi mumkin emas. Uy-joyidan mahrum etilgan mulkdorga uy-joyning qiymati hamda u ko‘rgan zararlarning o‘rni qonunda nazarda tutilgan hollarda va tartibda oldindan hamda teng qiymatda qoplanishi ta’minlanadi.\n" +
                "Davlat uy-joy qurilishini rag‘batlantiradi va uy-joyga bo‘lgan huquqning amalga oshirilishi uchun shart-sharoitlar yaratadi.\n" +
                "Aholining ijtimoiy jihatdan ehtiyojmand toifalarini uy-joy bilan ta’minlash tartibi qonun bilan belgilanadi."))

        substance9.add(Substance("48-modda","Har kim sog‘lig‘ini saqlash va malakali tibbiy xizmatdan foydalanish huquqiga ega.\n" +
                "O‘zbekiston Respublikasi fuqarolari tibbiy yordamning kafolatlangan hajmini qonunda belgilangan tartibda davlat hisobidan olishga haqli.\n" +
                "Davlat sog‘liqni saqlash tizimini, uning davlat va nodavlat shakllarini, tibbiy sug‘urtaning har xil turlarini rivojlantirish, aholining sanitariya-epidemiologik osoyishtaligini ta’minlash choralarini ko‘radi.\n" +
                "Davlat jismoniy tarbiya va sportni rivojlantirish, aholi o‘rtasida sog‘lom turmush tarzini shakllantirish uchun shart-sharoitlar yaratadi."))

        substance9.add(Substance("49-modda","Har kim qulay atrof-muhitga, uning holati to‘g‘risidagi ishonchli axborotga ega bo‘lish huquqiga ega.\n" +
                "Davlat fuqarolarning ekologik huquqlarini ta’minlash va atrof-muhitga zararli ta’sir ko‘rsatilishiga yo‘l qo‘ymaslik maqsadida shaharsozlik faoliyati sohasida jamoatchilik nazoratini amalga oshirish uchun shart-sharoitlar yaratadi.\n" +
                "Shaharsozlik hujjatlarining loyihalari qonunda belgilangan tartibda jamoatchilik muhokamasidan o‘tkaziladi.\n" +
                "Davlat barqaror rivojlanish prinsipiga muvofiq, atrof-muhitni yaxshilash, tiklash va muhofaza qilish, ekologik muvozanatni saqlash bo‘yicha chora-tadbirlarni amalga oshiradi.\n" +
                "Davlat Orolbo‘yi mintaqasining ekologik tizimini muhofaza qilish hamda tiklash, mintaqani ijtimoiy va iqtisodiy jihatdan rivojlantirish yuzasidan choralar ko‘radi."))

        substance9.add(Substance("50-modda","Har kim ta’lim olish huquqiga ega.\n" +
                "Davlat uzluksiz ta’lim tizimi, uning har xil turlari va shakllari, davlat va nodavlat ta’lim tashkilotlari rivojlanishini ta’minlaydi.\n" +
                "Davlat maktabgacha ta’lim va tarbiyani rivojlantirish uchun shart-sharoitlar yaratadi.\n" +
                "Davlat bepul umumiy o‘rta ta’lim va boshlang‘ich professional ta’lim olishni kafolatlaydi. Umumiy o‘rta ta’lim majburiydir.\n" +
                "Maktabgacha ta’lim va tarbiya, umumiy o‘rta ta’lim davlat nazoratidadir.\n" +
                "Ta’lim tashkilotlarida alohida ta’lim ehtiyojlariga ega bo‘lgan bolalar uchun inklyuziv ta’lim va tarbiya ta’minlanadi."))

        substance9.add(Substance("51-modda","Fuqarolar davlat ta’lim tashkilotlarida tanlov asosida davlat hisobidan oliy ma’lumot olishga haqli.\n" +
                "Oliy ta’lim tashkilotlari qonunga muvofiq akademik erkinlik, o‘zini o‘zi boshqarish, tadqiqotlar o‘tkazish va o‘qitish erkinligi huquqiga ega."))
        substance9.add(Substance("52-modda","O‘zbekiston Respublikasida o‘qituvchining mehnati jamiyat va davlatni rivojlantirish, sog‘lom, barkamol avlodni shakllantirish hamda tarbiyalash, xalqning ma’naviy va madaniy salohiyatini saqlash hamda boyitishning asosi sifatida e’tirof etiladi.\n" +
                "Davlat o‘qituvchilarning sha’ni va qadr-qimmatini himoya qilish, ularning ijtimoiy va moddiy farovonligi, kasbiy jihatdan o‘sishi to‘g‘risida g‘amxo‘rlik qiladi."))

        substance9.add(Substance("53-modda","Har kimga ilmiy, texnikaviy va badiiy ijod erkinligi, madaniyat yutuqlaridan foydalanish huquqi kafolatlanadi. Intellektual mulk qonun bilan muhofaza qilinadi.\n" +
                "Davlat jamiyatning madaniy, ilmiy va texnikaviy rivojlanishi haqida g‘amxo‘rlik qiladi."))



        chap2.add(Chap("IX bob. Iqtisodiy, ijtimoiy, madaniy va ekologik huquqlarr",substance9))

        val substance10=ArrayList<Substance>()
        substance10.add(Substance("54-modda","Insonning huquq va erkinliklarini ta’minlash davlatning oliy maqsadidir.\n" +
                "Davlat inson hamda fuqaroning Konstitutsiya va qonunlarda mustahkamlangan huquqlari va erkinliklarini ta’minlaydi."))

        substance10.add(Substance("55-modda","Har kim o‘z huquq va erkinliklarini qonunda taqiqlanmagan barcha usullar bilan himoya qilishga haqli.\n" +
                "Har kimga o‘z huquq va erkinliklarini sud orqali himoya qilish, davlat organlarining hamda boshqa tashkilotlarning, ular mansabdor shaxslarining qonunga xilof qarorlari, harakatlari va harakatsizligi ustidan sudga shikoyat qilish huquqi kafolatlanadi.\n" +
                "Har kimga buzilgan huquq va erkinliklarini tiklash uchun uning ishi qonunda belgilangan muddatlarda vakolatli, mustaqil hamda xolis sud tomonidan ko‘rib chiqilishi huquqi kafolatlanadi.\n" +
                "Har kim O‘zbekiston Respublikasining qonunchiligiga va xalqaro shartnomalariga muvofiq, agar davlatning huquqiy himoyaga doir barcha ichki vositalaridan foydalanib bo‘lingan bo‘lsa, insonning huquq va erkinliklarini himoya qiluvchi xalqaro organlarga murojaat etishga haqli.\n" +
                "Har kim davlat organlarining yoxud ular mansabdor shaxslarining qonunga xilof qarorlari, harakatlari yoki harakatsizligi tufayli yetkazilgan zararning o‘rni davlat tomonidan qoplanishi huquqiga ega."))

        substance10.add(Substance("56-modda","Inson huquqlari bo‘yicha milliy institutlar inson huquqlari va erkinliklarini himoya qilishning mavjud shakllari hamda vositalarini to‘ldiradi, fuqarolik jamiyatini rivojlantirishga va inson huquqlari madaniyatini yuksaltirishga ko‘maklashadi.\n" +
                "Davlat inson huquqlari bo‘yicha milliy institutlar faoliyatini tashkil etish uchun shart-sharoitlar yaratadi."))

        substance10.add(Substance("57-modda","Mehnatga layoqatsiz va yolg‘iz keksalar, nogironligi bo‘lgan shaxslar hamda aholining ijtimoiy jihatdan ehtiyojmand boshqa toifalarining huquqlari davlat himoyasidadir.\n" +
                "Davlat aholining ijtimoiy jihatdan ehtiyojmand toifalarining turmush sifatini oshirishga, jamiyat va davlat hayotida to‘laqonli ishtirok etishi uchun ularga shart-sharoitlar yaratishga hamda ularning asosiy hayotiy ehtiyojlarini mustaqil ravishda ta’minlash imkoniyatlarini kengaytirishga qaratilgan choralarni ko‘radi.\n" +
                "Davlat nogironligi bo‘lgan shaxslarning ijtimoiy, iqtisodiy va madaniy sohalar obyektlari va xizmatlaridan to‘laqonli foydalanishi uchun shart-sharoitlar yaratadi, ularning ishga joylashishiga, ta’lim olishiga ko‘maklashadi, ularga zarur bo‘lgan axborotni to‘sqinliksiz olish imkoniyatini ta’minlaydi."))

        substance10.add(Substance("58-modda","Xotin-qizlar va erkaklar teng huquqlidirlar.\n" +
                "Davlat xotin-qizlar va erkaklarga jamiyat hamda davlat ishlarini boshqarishda, shuningdek jamiyat va davlat hayotining boshqa sohalarida teng huquq va imkoniyatlarni ta’minlaydi."))



        chap2.add(Chap("X bob. Inson hamda fuqaroning huquq va erkinliklari kafolatlari",substance10))

        val substance11=ArrayList<Substance>()
        substance11.add(Substance("59-modda","Barcha fuqarolar Konstitutsiyada belgilab qo‘yilgan burchlarini bajaradilar."))
        substance11.add(Substance("60-modda","Fuqarolar Konstitutsiya va qonunlarga rioya etishga, boshqa insonlarning huquqlari, erkinliklari, sha’ni va qadr-qimmatini hurmat qilishga majburdirlar."))
        substance11.add(Substance("61-modda","Fuqarolar O‘zbekiston xalqining tarixiy, ma’naviy, madaniy, ilmiy va tabiiy merosini asrab-avaylashi shart.\n" +
                "Tarixiy, ma’naviy, madaniy, ilmiy va tabiiy meros davlat tomonidan muhofaza qilinadi."))

        substance11.add(Substance("62-modda","Fuqarolar atrof tabiiy muhitga ehtiyotkorona munosabatda bo‘lishga majburdirlar."))

        substance11.add(Substance("63-modda","Fuqarolar qonun bilan belgilangan soliqlar va yig‘imlarni to‘lashi shart.\n" +
                "Soliq va yig‘imlar adolatli bo‘lishi hamda fuqarolarning konstitutsiyaviy huquqlarini amalga oshirishiga to‘sqinlik qilmasligi kerak."))
        substance11.add(Substance("64-modda","O‘zbekiston Respublikasini himoya qilish O‘zbekiston Respublikasi har bir fuqarosining burchidir. Fuqarolar qonunda belgilangan tartibda harbiy yoki muqobil xizmatni o‘tashga majburdirlar."))

        chap2.add(Chap("XI bob. Fuqarolarning burchlari",substance11))
        list.add(Department("IKKINChI BO‘LIM. INSON VA FUQARONING ASOSIY HUQUQLARI, ERKINLIKLARI VA BURChLARI",chap2))

        val chap3=ArrayList<Chap>()
        val substance12=ArrayList<Substance>()

        substance12.add(Substance("65-modda","Fuqarolar farovonligini oshirishga qaratilgan O‘zbekiston iqtisodiyotining negizini xilma-xil shakllardagi mulk tashkil etadi. Davlat bozor munosabatlarini rivojlantirish va halol raqobat uchun shart-sharoitlar yaratadi, iste’molchilarning huquqlari ustuvorligini hisobga olgan holda iqtisodiy faoliyat, tadbirkorlik va mehnat qilish erkinligini kafolatlaydi.\n" +
                "O‘zbekiston Respublikasida barcha mulk shakllarining teng huquqliligi va huquqiy jihatdan himoya qilinishi ta’minlanadi.\n" +
                "Xususiy mulk daxlsizdir. Mulkdor o‘z mol-mulkidan qonunda nazarda tutilgan hollardan va tartibdan tashqari hamda sudning qaroriga asoslanmagan holda mahrum etilishi mumkin emas."))

        substance12.add(Substance("66-modda","Mulkdor o‘ziga tegishli bo‘lgan mol-mulkka o‘z xohishicha egalik qiladi, undan foydalanadi va uni tasarruf etadi. Mol-mulkdan foydalanish atrof-muhitga zarar yetkazmasligi, boshqa shaxslarning, jamiyat va davlatning huquqlarini hamda qonuniy manfaatlarini buzmasligi kerak."))

        substance12.add(Substance("67-modda","Davlat qulay investitsiyaviy va ishbilarmonlik muhitini ta’minlaydi.\n" +
                "Tadbirkorlar qonunchilikka muvofiq har qanday faoliyatni amalga oshirishga va o‘z faoliyati yo‘nalishlarini mustaqil ravishda tanlashga haqli.\n" +
                "O‘zbekiston Respublikasi hududida iqtisodiy makon birligi, tovarlar, xizmatlar, mehnat resurslari va moliyaviy mablag‘larning erkin harakatlanishi kafolatlanadi.\n" +
                "Monopol faoliyat qonun bilan tartibga solinadi va cheklanadi."))

        substance12.add(Substance("68-modda","Yer, yer osti boyliklari, suv, o‘simlik va hayvonot dunyosi hamda boshqa tabiiy resurslar umummilliy boylikdir, ulardan oqilona foydalanish zarur va ular davlat muhofazasidadir.\n" +
                "Yer qonunda nazarda tutilgan hamda undan oqilona foydalanishni va uni umummilliy boylik sifatida muhofaza qilishni ta’minlovchi shartlar asosida va tartibda xususiy mulk bo‘lishi mumkin."))



        chap3.add(Chap("XII bob. Jamiyatning iqtisodiy negizlari",substance12))

        val substance13=ArrayList<Substance>()
        substance13.add(Substance("69-modda","Fuqarolik jamiyati institutlari, shu jumladan jamoat birlashmalari va boshqa nodavlat notijorat tashkilotlari, fuqarolarning o‘zini o‘zi boshqarish organlari, ommaviy axborot vositalari fuqarolik jamiyatining asosini tashkil etadi.\n" +
                "Fuqarolik jamiyati institutlarining faoliyati qonunga muvofiq amalga oshiriladi."))

        substance13.add(Substance("70-modda","O‘zbekiston Respublikasida kasaba uyushmalari, siyosiy partiyalar, olimlarning jamiyatlari, xotin-qizlar tashkilotlari, faxriylar, yoshlar va nogironligi bo‘lgan shaxslar tashkilotlari, ijodiy uyushmalar, ommaviy harakatlar hamda fuqarolarning boshqa birlashmalari jamoat birlashmalari sifatida e’tirof etiladi.\n" +
                "Jamoat birlashmalarini tarqatib yuborish, ularning faoliyatini taqiqlab yoki cheklab qo‘yish faqat sud qarori asosidagina amalga oshiriladi."))

        substance13.add(Substance("71-modda","Konstitutsiyaviy tuzumni zo‘rlik bilan o‘zgartirishni maqsad qilib qo‘yuvchi, O‘zbekistonning davlat suverenitetiga, hududiy yaxlitligiga va xavfsizligiga qarshi chiquvchi, urushni, ijtimoiy, milliy, irqiy hamda diniy adovatni targ‘ib qiluvchi, fuqarolarning konstitutsiyaviy huquqlari va erkinliklariga, aholining sog‘lig‘iga, ijtimoiy axloqqa tajovuz qiluvchi siyosiy partiyalarning, boshqa nodavlat notijorat tashkilotlarining, shuningdek milliy va diniy belgilariga ko‘ra siyosiy partiyalarning, harbiylashtirilgan birlashmalarning tashkil etilishi va faoliyati taqiqlanadi.\n" +
                "Maxfiy jamiyatlar va birlashmalar tashkil etish taqiqlanadi."))

        substance13.add(
            Substance(
                "72-modda",
                "Davlat nodavlat notijorat tashkilotlarining huquqlari va qonuniy manfaatlariga rioya etilishini ta’minlaydi, ularga jamiyat hayotida ishtirok etish uchun teng huquqiy imkoniyatlar yaratadi.\n" +
                        "Davlat organlari va mansabdor shaxslarning nodavlat notijorat tashkilotlari faoliyatiga aralashishiga, shuningdek nodavlat notijorat tashkilotlarining davlat organlari va mansabdor shaxslar faoliyatiga aralashishiga yo‘l qo‘yilmaydi.")
        )
        substance13.add(Substance("73-modda","Kasaba uyushmalari xodimlarning ijtimoiy-iqtisodiy huquqlarini va manfaatlarini ifoda etadilar va himoya qiladilar. Kasaba uyushmalariga a’zo bo‘lish ixtiyoriydir."))
        substance13.add(Substance("74-modda","Siyosiy partiyalar turli ijtimoiy tabaqa va guruhlarning siyosiy irodasini ifodalaydilar va o‘zlarining demokratik yo‘l bilan saylab qo‘yilgan vakillari orqali davlat hokimiyatini tuzishda ishtirok etadilar. Siyosiy partiyalar o‘z faoliyatining moliyalashtirilishi manbalari haqida O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasiga yoki u vakolat bergan organga belgilangan tartibda oshkora hisobotlar taqdim etadilar."))
        substance13.add(Substance("75-modda","Diniy tashkilotlar davlatdan ajratilgan hamda qonun oldida tengdirlar. Davlat diniy tashkilotlarning faoliyatiga aralashmaydi.\n" +
                "Davlat qonunda belgilangan tartibda faoliyat ko‘rsatayotgan diniy tashkilotlar faoliyatining erkinligini kafolatlaydi."))


        chap3.add(Chap("XIII bob. Fuqarolik jamiyati institutlari",substance13))

        val substance14=ArrayList<Substance>()

        substance14.add(Substance("76-modda","Oila jamiyatning asosiy bo‘g‘inidir hamda u jamiyat va davlat muhofazasidadir.\n" +
                "Nikoh O‘zbekiston xalqining an’anaviy oilaviy qadriyatlariga, nikohlanuvchilarning ixtiyoriy roziligiga va teng huquqliligiga asoslanadi.\n" +
                "Davlat oilaning to‘laqonli rivojlanishi uchun ijtimoiy, iqtisodiy, huquqiy va boshqa shart-sharoitlar yaratadi."))

        substance14.add(Substance("77-modda","Ota-onalar va ularning o‘rnini bosuvchi shaxslar o‘z farzandlarini voyaga yetguniga qadar boqishi, ularning tarbiyasi, ta’lim olishi, sog‘lom, to‘laqonli va har tomonlama kamol topishi xususida g‘amxo‘rlik qilishga majburdirlar.\n" +
                "Davlat va jamiyat yetim bolalarni hamda ota-onasining vasiyligidan mahrum bo‘lgan bolalarni boqishni, tarbiyalashni, ularning ta’lim olishini, sog‘lom, to‘laqonli va har tomonlama kamol topishini ta’minlaydi, shu maqsadda xayriya faoliyatini rag‘batlantiradi."))

        substance14.add(Substance("78-modda","Farzandlar ota-onasining nasl-nasabi va fuqarolik holatidan qat’i nazar, qonun oldida tengdirlar.\n" +
                "Bolaning huquqlari, erkinliklari va qonuniy manfaatlarini ta’minlash hamda himoya qilish, uning jismoniy, aqliy va madaniy jihatdan to‘laqonli rivojlanishi uchun eng yaxshi shart-sharoitlarni yaratish davlatning majburiyatidir.\n" +
                "Onalik, otalik va bolalik davlat tomonidan muhofaza qilinadi.\n" +
                "Davlat va jamiyat bolalarda hamda yoshlarda milliy va umuminsoniy qadriyatlarga sodiqlikni, mamlakatidan hamda xalqning boy madaniy merosidan faxrlanishni, vatanparvarlik va Vatanga bo‘lgan mehr-muhabbat tuyg‘ularini shakllantirish to‘g‘risida g‘amxo‘rlik qiladi."))

        substance14.add(Substance("79-modda","Davlat yoshlarning shaxsiy, siyosiy, iqtisodiy, ijtimoiy, madaniy, ekologik huquqlari himoya qilinishini ta’minlaydi, ularning jamiyat va davlat hayotida faol ishtirok etishini rag‘batlantiradi.\n" +
                "Davlat yoshlarning intellektual, ijodiy, jismoniy va axloqiy jihatdan shakllanishi hamda rivojlanishi uchun, ularning ta’lim olishga, sog‘lig‘ini saqlashga, uy-joyga, ishga joylashishga, bandlik va dam olishga bo‘lgan huquqlarini amalga oshirish uchun shart-sharoitlar yaratadi."))

        substance14.add(Substance("80-modda","Voyaga yetgan mehnatga layoqatli farzandlar o‘z ota-onalari haqida g‘amxo‘rlik qilishga majburdirlar."))



        chap3.add(Chap("XIV bob. Oila, bolalar va yoshlar",substance14))

        val substance15=ArrayList<Substance>()

        substance15.add(Substance("81-modda","Ommaviy axborot vositalari erkindir va qonunga muvofiq ish olib boradilar.\n" +
                "Davlat ommaviy axborot vositalari faoliyatining erkinligini, ularning axborotni izlash, olish, undan foydalanish va uni tarqatishga bo‘lgan huquqlari amalga oshirilishini kafolatlaydi.\n" +
                "Ommaviy axborot vositalari o‘zi taqdim etadigan axborotning ishonchliligi uchun javobgardir."))

        substance15.add(Substance("82-modda","Senzuraga yo‘l qo‘yilmaydi.\n" +
                "Ommaviy axborot vositalarining faoliyatiga to‘sqinlik qilish yoki aralashish qonunga muvofiq javobgarlikka sabab bo‘ladi."))



        chap3.add(Chap("XV bob. Ommaviy axborot vositalari",substance15))
        list.add(Department("UChINChI BO‘LIM. JAMIYAT VA ShAXS",chap3))

        val chap4=ArrayList<Chap>()

        val substance16=ArrayList<Substance>()

        substance16.add(Substance("83-modda","O‘zbekiston Respublikasi viloyatlar, tumanlar, shaharlar, shaharchalar, qishloqlar, ovullar, shuningdek Qoraqalpog‘iston Respublikasidan iborat."))
        substance16.add(Substance("84-modda","Qoraqalpog‘iston Respublikasi, viloyatlar, Toshkent shahrining chegaralarini o‘zgartirish, shuningdek viloyatlar, shaharlar, tumanlar tashkil qilish va ularni tugatish O‘zbekiston Respublikasi Oliy Majlisining roziligi bilan amalga oshiriladi."))

        chap4.add(Chap("XVI bob. O‘zbekiston Respublikasining ma’muriy-hududiy tuzilishi",substance16))

        val substance17=ArrayList<Substance>()

        substance17.add(
            Substance(
                "85-modda",
                "Suveren Qoraqalpog‘iston Respublikasi O‘zbekiston Respublikasi tarkibiga kiradi.\n" +
                        "Qoraqalpog‘iston Respublikasining suvereniteti O‘zbekiston Respublikasi tomonidan muhofaza etiladi.")
        )

        substance17.add(Substance("86-modda","Qoraqalpog‘iston Respublikasi o‘z Konstitutsiyasiga ega.\n" +
                "Qoraqalpog‘iston Respublikasining Konstitutsiyasi O‘zbekiston Respublikasining Konstitutsiyasiga zid bo‘lishi mumkin emas."))

        substance17.add(Substance("87-modda","O‘zbekiston Respublikasi qonunlari Qoraqalpog‘iston Respublikasi hududida ham majburiydir."))
        substance17.add(Substance("88-modda","Qoraqalpog‘iston Respublikasining hududi va chegaralari uning roziligisiz o‘zgartirilishi mumkin emas. Qoraqalpog‘iston Respublikasi o‘z ma’muriy-hududiy tuzilishi masalalarini mustaqil hal qiladi."))

        substance17.add(Substance("89-modda","Qoraqalpog‘iston Respublikasi O‘zbekiston Respublikasi tarkibidan Qoraqalpog‘iston Respublikasi xalqining umumiy referendumi asosida ajralib chiqish huquqiga ega."))

        substance17.add(
            Substance(
                "90-modda",
                "O‘zbekiston Respublikasi bilan Qoraqalpog‘iston Respublikasining o‘zaro munosabatlari O‘zbekiston Respublikasi va Qoraqalpog‘iston Respublikasi o‘rtasida O‘zbekiston Respublikasi Konstitutsiyasi doirasida tuzilgan shartnomalar hamda bitimlar bilan tartibga solinadi.\n" +
                        "O‘zbekiston Respublikasi va Qoraqalpog‘iston Respublikasi o‘rtasidagi nizolar murosaga keltiruvchi vositalar yordamida hal etiladi.")
        )


        chap4.add(Chap("XVII bob. Qoraqalpog‘iston Respublikasi",substance17))

        list.add(Department("TO‘RTINChI BO‘LIM. MA’MURIY-HUDUDIY VA DAVLAT TUZILIShI",chap4))

        val chap5=ArrayList<Chap>()
        val substance18=ArrayList<Substance>()
        substance18.add(Substance("91-modda","O‘zbekiston Respublikasining Oliy Majlisi oliy davlat vakillik organi bo‘lib, qonun chiqaruvchi hokimiyatni amalga oshiradi.\n" +
                "O‘zbekiston Respublikasi Oliy Majlisi ikki palatadan — Qonunchilik palatasi (quyi palata) va Senatdan (yuqori palata) iborat.\n" +
                "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi va Senati vakolat muddati — besh yil."))

        substance18.add(
            Substance(
                "92-modda",
                "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi qonunga muvofiq saylanadigan bir yuz ellik deputatdan iborat.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati hududiy vakillik palatasi bo‘lib, Senat a’zolaridan (senatorlardan) iborat.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati a’zolari Qoraqalpog‘iston Respublikasi Jo‘qorg‘i Kengesi, viloyatlar, tumanlar va shaharlar davlat hokimiyati vakillik organlari deputatlarining tegishli qo‘shma majlislarida mazkur deputatlar orasidan yashirin ovoz berish yo‘li bilan Qoraqalpog‘iston Respublikasi, viloyatlar va Toshkent shahridan teng miqdorda — to‘rt kishidan saylanadi. O‘zbekiston Respublikasi Oliy Majlisi Senatining to‘qqiz nafar a’zosi fan, san’at, adabiyot, ishlab chiqarish sohasida hamda davlat va jamiyat faoliyatining boshqa tarmoqlarida katta amaliy tajribaga ega bo‘lgan hamda alohida xizmat ko‘rsatgan eng obro‘li fuqarolar orasidan O‘zbekiston Respublikasi Prezidenti tomonidan tayinlanadi.\n" +
                        "Saylov kuni yigirma besh yoshga to‘lgan hamda kamida besh yil O‘zbekiston Respublikasi hududida muqim yashayotgan O‘zbekiston Respublikasi fuqarosi O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputati, shuningdek O‘zbekiston Respublikasi Oliy Majlisining Senati a’zosi bo‘lishi mumkin. Deputatlikka nomzodlarga qo‘yiladigan talablar qonun bilan belgilanadi.\n" +
                        "Ayni bir shaxs bir paytning o‘zida O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputati va Senati a’zosi bo‘lishi mumkin emas.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasining deputati bir vaqtning o‘zida Qoraqalpog‘iston Respublikasi Jo‘qorg‘i Kengesining, viloyatlar, tumanlar, shaharlar davlat hokimiyati vakillik organlarining deputati bo‘lishi mumkin emas.")
        )
        substance18.add(
            Substance(
                "93-modda",
                "O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasi va Senatining birgalikdagi vakolatlari quyidagilardan iborat:\n" +
                        "1) O‘zbekiston Respublikasining Konstitutsiyasini qabul qilish, unga o‘zgartirish va qo‘shimchalar kiritish;\n" +
                        "2) O‘zbekiston Respublikasining konstitutsiyaviy qonunlarini, qonunlarini qabul qilish, ularga o‘zgartirish va qo‘shimchalar kiritish;\n" +
                        "3) xalqaro shartnomalarni ratifikatsiya va denonsatsiya qilish;\n" +
                        "4) O‘zbekiston Respublikasining referendumini o‘tkazish to‘g‘risida va uni o‘tkazish sanasini tayinlash haqida qaror qabul qilish;\n" +
                        "5) O‘zbekiston Respublikasi ichki va tashqi siyosatining asosiy yo‘nalishlarini belgilash hamda davlat strategik dasturlarini qabul qilish;\n" +
                        "6) O‘zbekiston Respublikasi qonun chiqaruvchi, ijro etuvchi hamda sud hokimiyati organlarining tizimini va vakolatlarini belgilash;\n" +
                        "7) O‘zbekiston Respublikasi tarkibiga yangi davlat tuzilmalarini qabul qilish va ularning O‘zbekiston Respublikasi tarkibidan chiqishi haqidagi qarorlarni tasdiqlash;\n" +
                        "8) bojxona, valyuta va kredit ishlarini qonun yo‘li bilan tartibga solish;\n" +
                        "9) O‘zbekiston Respublikasi Vazirlar Mahkamasining taqdimiga binoan O‘zbekiston Respublikasining Davlat budjetini qabul qilish, unga o‘zgartirish va qo‘shimchalar kiritish;\n" +
                        "10) O‘zbekiston Respublikasi davlat qarzining eng yuqori miqdorini belgilash;\n" +
                        "11) soliqlar va boshqa majburiy to‘lovlarni joriy qilish;\n" +
                        "12) O‘zbekiston Respublikasining ma’muriy-hududiy tuzilishi masalalarini qonun yo‘li bilan tartibga solish, chegaralarini o‘zgartirish;\n" +
                        "13) tumanlar, shaharlar, viloyatlarni tashkil etish, tugatish, ularning nomini hamda chegaralarini o‘zgartirish;\n" +
                        "14) davlat mukofotlari va unvonlarini ta’sis etish;\n" +
                        "15) O‘zbekiston Respublikasi Markaziy saylov komissiyasini tuzish;\n" +
                        "16) O‘zbekiston Respublikasi Oliy Majlisining Inson huquqlari bo‘yicha vakilini va uning o‘rinbosarini saylash;\n" +
                        "17) O‘zbekiston Respublikasi Prezidentining O‘zbekiston Respublikasiga hujum qilinganda yoki tajovuzdan bir-birini mudofaa qilish yuzasidan tuzilgan shartnoma majburiyatlarini bajarish zaruriyati tug‘ilganda urush holati e’lon qilish to‘g‘risidagi farmonini tasdiqlash;\n" +
                        "18) O‘zbekiston Respublikasi Prezidentining umumiy yoki qisman safarbarlik e’lon qilish, favqulodda holat joriy etish, uning amal qilishini uzaytirish yoki tugatish to‘g‘risidagi farmonlarini tasdiqlash;\n" +
                        "19) O‘zbekiston Respublikasida korrupsiyaga qarshi kurashish to‘g‘risidagi har yilgi milliy ma’ruzani eshitish;\n" +
                        "20) parlament tekshiruvini o‘tkazish;\n" +
                        "21) ushbu Konstitutsiya va qonunlarda nazarda tutilgan boshqa vakolatlarni amalga oshirish.\n" +
                        "Palatalarning birgalikdagi vakolatlariga kiradigan masalalar, qoida tariqasida, avval O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasida, so‘ngra Senatida ko‘rib chiqiladi.")
        )

        substance18.add(Substance("94-modda","O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi mutlaq vakolatlari quyidagilardan iborat:\n" +
                "1) O‘zbekiston Respublikasi Davlat budjetining ijro etilishi ustidan nazoratni amalga oshirish;\n" +
                "2) O‘zbekiston Respublikasi Hisob palatasining hisobotini ko‘rib chiqish;\n" +
                "3) O‘zbekiston Respublikasi Prezidentining taqdimiga binoan O‘zbekiston Respublikasi Bosh vaziri nomzodini ko‘rib chiqish va ma’qullash;\n" +
                "4) O‘zbekiston Respublikasi Bosh vazirining mamlakatni ijtimoiy-iqtisodiy jihatdan rivojlantirishning dolzarb masalalari yuzasidan, shuningdek Vazirlar Mahkamasi a’zolarining o‘z faoliyati masalalari yuzasidan hisobotlarini eshitish;\n" +
                "5) O‘zbekiston Respublikasi Prezidentining taqdimiga binoan O‘zbekiston Respublikasi Vazirlar Mahkamasi a’zoligiga nomzodlarni ko‘rib chiqish va ma’qullash;\n" +
                "6) O‘zbekiston Respublikasi Vazirlar Mahkamasining mamlakat ijtimoiy-iqtisodiy hayotining eng muhim masalalari bo‘yicha har yilgi ma’ruzasini eshitish;\n" +
                "7) davlat organlarining mansabdor shaxslariga parlament so‘rovini yuborish va parlament nazoratining boshqa shakllarini amalga oshirish;\n" +
                "8) O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi Spikeri va uning o‘rinbosarlarini, qo‘mitalarning raislari va ularning o‘rinbosarlarini saylash;\n" +
                "9) O‘zbekiston Respublikasi Bosh prokurorining taqdimiga binoan O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputatini daxlsizlik huquqidan mahrum etish to‘g‘risidagi masalalarni hal etish;\n" +
                "10) o‘z faoliyatini tashkil etish va palataning ichki tartib-qoidalari bilan bog‘liq masalalar yuzasidan qarorlar qabul qilish;\n" +
                "11) siyosiy, ijtimoiy-iqtisodiy hayot sohasidagi u yoki bu masalalar yuzasidan, shuningdek davlatning ichki va tashqi siyosati masalalari yuzasidan qarorlar qabul qilish;\n" +
                "12) ushbu Konstitutsiya va qonunlarda nazarda tutilgan boshqa vakolatlarni amalga oshirish.\n" +
                "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi o‘zini o‘zi tarqatib yuborish to‘g‘risida deputatlar umumiy sonining kamida uchdan ikki qismidan iborat ko‘pchilik ovozi bilan qaror qabul qilishi mumkin."))


        substance18.add(
            Substance(
                "95-modda",
                "O‘zbekiston Respublikasi Oliy Majlisining Senati mutlaq vakolatlari quyidagilardan iborat:\n" +
                        "1) O‘zbekiston Respublikasi Prezidentining taqdimiga binoan O‘zbekiston Respublikasi Konstitutsiyaviy sudini, Oliy sudini, Sudyalar oliy kengashini, respublika korrupsiyaga qarshi kurashish organining rahbarini va respublika monopoliyaga qarshi organining rahbarini saylash;\n" +
                        "2) O‘zbekiston Respublikasi Prezidentining taqdimiga binoan O‘zbekiston Respublikasi Bosh prokurori va O‘zbekiston Respublikasi Hisob palatasi raisi lavozimlariga nomzodlarni ko‘rib chiqish hamda ma’qullash;\n" +
                        "3) O‘zbekiston Respublikasi Prezidenti tomonidan taklif etilgan O‘zbekiston Respublikasi Davlat xavfsizlik xizmati raisi lavozimiga nomzod yuzasidan maslahatlashuvlar o‘tkazish;\n" +
                        "4) O‘zbekiston Respublikasi Prezidentining taqdimiga binoan O‘zbekiston Respublikasining chet davlatlardagi va xalqaro tashkilotlar huzuridagi diplomatik hamda boshqa vakolatxonalari rahbarlarini tayinlash va ularni lavozimidan ozod etish;\n" +
                        "5) O‘zbekiston Respublikasi Prezidentining taqdimiga binoan O‘zbekiston Respublikasi Markaziy banki boshqaruvining raisini tayinlash va uni lavozimidan ozod etish;\n" +
                        "6) O‘zbekiston Respublikasi Prezidentining vazirliklarni va boshqa respublika ijro etuvchi hokimiyat organlarini tuzish hamda tugatish to‘g‘risidagi farmonlarini tasdiqlash;\n" +
                        "7) O‘zbekiston Respublikasi Prezidentining taqdimiga binoan amnistiya to‘g‘risidagi hujjatlarni qabul qilish;\n" +
                        "8) O‘zbekiston Respublikasi Bosh prokurorining, O‘zbekiston Respublikasi Markaziy banki boshqaruvi raisining hisobotlarini eshitish;\n" +
                        "9) O‘zbekiston Respublikasining chet davlatlardagi va xalqaro tashkilotlar huzuridagi diplomatik hamda boshqa vakolatxonalari rahbarlarining o‘z faoliyati masalalari bo‘yicha hisobotlarini eshitish;\n" +
                        "10) davlat organlarining mansabdor shaxslariga parlament so‘rovini yuborish va parlament nazoratining boshqa shakllarini amalga oshirish;\n" +
                        "11) mahalliy davlat hokimiyati vakillik organlariga o‘z faoliyatini amalga oshirishda ko‘maklashish;\n" +
                        "12) mahalliy davlat hokimiyati vakillik organlarining qarorlarini, ular qonunchilik normalariga muvofiq bo‘lmagan taqdirda, bekor qilish;\n" +
                        "13) O‘zbekiston Respublikasi Oliy Majlisining Senati Raisini va uning o‘rinbosarlarini, qo‘mitalarning raislari va ularning o‘rinbosarlarini saylash;\n" +
                        "14) O‘zbekiston Respublikasi Bosh prokurorining taqdimiga binoan O‘zbekiston Respublikasi Oliy Majlisining Senati a’zosini daxlsizlik huquqidan mahrum etish to‘g‘risidagi masalalarni hal etish;\n" +
                        "15) o‘z faoliyatini tashkil etish va palataning ichki tartib-qoidalari bilan bog‘liq masalalar yuzasidan qarorlar qabul qilish;\n" +
                        "16) siyosiy, ijtimoiy-iqtisodiy hayot sohasidagi u yoki bu masalalar yuzasidan, shuningdek davlat ichki va tashqi siyosati masalalari yuzasidan qarorlar qabul qilish;\n" +
                        "17) Qonunchilik palatasi tarqatib yuborilgan davrda O‘zbekiston Respublikasi Oliy Majlisining qonunlarni qabul qilishga doir vakolatlarini bajarish, bundan Konstitutsiya va konstitutsiyaviy qonunlar mustasno;\n" +
                        "18) ushbu Konstitutsiya va qonunlarda nazarda tutilgan boshqa vakolatlarni amalga oshirish.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati o‘zini o‘zi tarqatib yuborish to‘g‘risida senatorlar umumiy sonining kamida uchdan ikki qismidan iborat ko‘pchilik ovozi bilan qaror qabul qilishi mumkin.")
        )
        substance18.add(
            Substance(
                "96-modda",
                "Vakolat muddati tugagach, O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi va Senati tegishincha yangi chaqiriq Qonunchilik palatasi va Senati ish boshlaguniga qadar o‘z faoliyatini davom ettirib turadi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasi va Senatining birinchi majlislari tegishincha Qonunchilik palatasiga saylovdan keyin ikki oydan kechiktirmay va Senat tarkib topganidan keyin bir oydan kechiktirmay Markaziy saylov komissiyasi tomonidan chaqiriladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi majlislari sessiyalar davrida o‘tkaziladi. Sessiyalar, qoida tariqasida, sentyabrning birinchi ish kunidan boshlab kelgusi yilning iyun oyi oxirgi ish kuniga qadar o‘tkaziladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati majlislari zaruratga qarab, lekin yiliga kamida uch marta o‘tkaziladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisi palatalarining majlislari, agar ular ishida barcha deputatlar, senatorlar umumiy sonining yarmidan ko‘pi ishtirok etayotgan bo‘lsa, vakolatli hisoblanadi.\n" +
                        "Konstitutsiyaviy qonunlarni qabul qilishda barcha deputatlar, senatorlar umumiy sonining kamida uchdan ikki qismi ishtirok etishi shart.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi va Senati majlislarida, shuningdek ularning organlari majlislarida O‘zbekiston Respublikasi Prezidenti, Bosh vazir, Vazirlar Mahkamasining a’zolari, Konstitutsiyaviy sud, Oliy sud, Sudyalar oliy kengashi raislari, Bosh prokuror, Markaziy bank boshqaruvining raisi ishtirok etishlari mumkin. O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi va uning organlari majlislarida Senat Raisi, O‘zbekiston Respublikasi Oliy Majlisining Senati va uning organlari majlislarida Qonunchilik palatasi Spikeri ishtirok etishi mumkin.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi va Senati alohida-alohida majlis o‘tkazadilar.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasi va Senatining qo‘shma majlislari O‘zbekiston Respublikasi Prezidenti qasamyod qilganda, O‘zbekiston Respublikasi Prezidenti mamlakat ijtimoiy-iqtisodiy hayotining, ichki va tashqi siyosatining eng muhim masalalari yuzasidan nutq so‘zlaganda, chet davlatlarning rahbarlari nutq so‘zlaganda o‘tkaziladi. Palatalarning kelishuviga binoan qo‘shma majlislar boshqa masalalar yuzasidan ham o‘tkazilishi mumkin.")
        )
        substance18.add(
            Substance(
                "97-modda",
                "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi va Senati o‘z vakolatlariga kiritilgan masalalar yuzasidan qarorlar qabul qiladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasi va Senatining qarorlari Qonunchilik palatasi deputatlari yoki Senat a’zolari umumiy sonining ko‘pchilik ovozi bilan qabul qilinadi, ushbu Konstitutsiyada nazarda tutilgan hollar bundan mustasno.")
        )
        substance18.add(
            Substance(
                "98-modda",
                "Qonunchilik tashabbusi huquqiga O‘zbekiston Respublikasi Prezidenti, davlat hokimiyatining oliy vakillik organi orqali Qoraqalpog‘iston Respublikasi, O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputatlari, O‘zbekiston Respublikasi Vazirlar Mahkamasi ega. O‘zbekiston Respublikasining Konstitutsiyaviy sudi, Oliy sudi va Bosh prokurori ham o‘z vakolatlari jumlasiga kiritilgan masalalar bo‘yicha qonunchilik tashabbusi huquqiga egadir.\n" +
                        "Qonunchilik tashabbusi huquqi qonun loyihasini qonunchilik tashabbusi huquqi subyektlari tomonidan O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasiga kiritish orqali amalga oshiriladi.\n" +
                        "O‘zbekiston Respublikasining saylov huquqiga ega bo‘lgan, yuz ming nafardan kam bo‘lmagan fuqarolari, O‘zbekiston Respublikasi Oliy Majlisining Senati, O‘zbekiston Respublikasi Oliy Majlisining Inson huquqlari bo‘yicha vakili (ombudsman), O‘zbekiston Respublikasi Markaziy saylov komissiyasi qonunchilik takliflarini qonunchilik tashabbusi tartibida O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasiga kiritishga haqli.\n" +
                        "Qonun loyihalarini, qonunchilik takliflarini kiritish va ko‘rib chiqish tartibi qonun bilan belgilanadi.")
        )
        substance18.add(
            Substance(
                "99-modda",
                "Qonun Qonunchilik palatasi tomonidan qabul qilinib, Senat tomonidan ma’qullanib, O‘zbekiston Respublikasi Prezidenti tomonidan imzolangach va qonunda belgilangan tartibda rasmiy manbalarda e’lon qilingach, yuridik kuchga ega bo‘ladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi tomonidan qabul qilingan qonun qabul qilingan kundan e’tiboran o‘n kundan kechiktirmay O‘zbekiston Respublikasi Oliy Majlisining Senatiga yuboriladi.\n" +
                        "Qonun O‘zbekiston Respublikasi Oliy Majlisining Senati tomonidan oltmish kun ichida ko‘rib chiqiladi va ma’qullangan taqdirda, imzolanishi va e’lon qilinishi uchun O‘zbekiston Respublikasi Prezidentiga o‘n kundan kechiktirmay yuboriladi.\n" +
                        "Agar O‘zbekiston Respublikasi Oliy Majlisining Senati qonunni ma’qullash yoki rad etish to‘g‘risida oltmish kun ichida qaror qabul qilmasa, Qonunchilik palatasi tomonidan qonun imzolanishi va e’lon qilinishi uchun O‘zbekiston Respublikasi Prezidentiga yuboriladi.\n" +
                        "O‘zbekiston Respublikasi Prezidenti qonunni oltmish kun ichida imzolaydi va e’lon qiladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati tomonidan rad etilgan qonun O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasiga qaytariladi.\n" +
                        "Agar O‘zbekiston Respublikasi Oliy Majlisining Senati tomonidan rad etilgan qonunni qayta ko‘rib chiqishda Qonunchilik palatasi deputatlar umumiy sonining uchdan ikki qismidan iborat ko‘pchilik ovozi bilan qonunni yana ma’qullasa, qonun O‘zbekiston Respublikasi Oliy Majlisi tomonidan qabul qilingan hisoblanadi hamda imzolanishi va e’lon qilinishi uchun O‘zbekiston Respublikasi Prezidentiga Qonunchilik palatasi tomonidan yuboriladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati tomonidan rad etilgan qonun yuzasidan Qonunchilik palatasi va Senat yuzaga kelgan kelishmovchiliklarni bartaraf etish uchun Qonunchilik palatasi deputatlari va Senat a’zolari orasidan tenglik asosida kelishuv komissiyasini tuzishi mumkin. Palatalar kelishuv komissiyasi takliflarini qabul qilganda qonun odatdagi tartibda ko‘rib chiqilishi kerak.\n" +
                        "O‘zbekiston Respublikasi Prezidenti qonunni o‘z e’tirozlari bilan O‘zbekiston Respublikasi Oliy Majlisiga qaytarishga haqli.\n" +
                        "Agar qonun avvalgi qabul qilingan tahririda tegishincha O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputatlari va Senati a’zolari umumiy sonining kamida uchdan ikki qismidan iborat ko‘pchilik ovozi bilan ma’qullansa, qonun O‘zbekiston Respublikasi Prezidenti tomonidan o‘n to‘rt kun ichida imzolanishi va e’lon qilinishi kerak.\n" +
                        "Qonunlarning va boshqa normativ-huquqiy hujjatlarning e’lon qilinishi ular qo‘llanilishining majburiy shartidir.")
        )
        substance18.add(
            Substance(
                "100-modda",
                "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi o‘z tarkibidan Qonunchilik palatasining Spikeri va uning o‘rinbosarlarini saylaydi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi Spikeri va uning o‘rinbosarlari yashirin ovoz berish orqali deputatlar umumiy sonining ko‘pchilik ovozi bilan Qonunchilik palatasining vakolati muddatiga saylanadi.\n" +
                        "Ayni bir shaxs surunkasiga ikki muddatdan ortiq O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasining Spikeri bo‘lishi mumkin emas.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi Spikeri va uning o‘rinbosarlari yashirin ovoz berish orqali Qonunchilik palatasi deputatlari umumiy sonining uchdan ikki qismidan ko‘prog‘ining ovozi bilan qabul qilingan Qonunchilik palatasi qaroriga binoan muddatidan ilgari chaqirib olinishi mumkin.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi Spikeri:\n" +
                        "1) Qonunchilik palatasining majlislarini chaqiradi, ularda raislik qiladi;\n" +
                        "2) Qonunchilik palatasi muhokamasiga kiritiladigan masalalarni tayyorlashga umumiy rahbarlik qiladi;\n" +
                        "3) Qonunchilik palatasi qo‘mitalari va komissiyalarining faoliyatini muvofiqlashtirib boradi;\n" +
                        "4) O‘zbekiston Respublikasi qonunlarining va Qonunchilik palatasi qarorlarining ijrosi ustidan nazoratni tashkil etadi;\n" +
                        "5) parlamentlararo aloqalarni amalga oshirish ishlariga hamda xalqaro parlament tashkilotlari ishi bilan bog‘liq Qonunchilik palatasi guruhlarining faoliyatiga rahbarlik qiladi;\n" +
                        "6) O‘zbekiston Respublikasi Oliy Majlisining Senati, boshqa davlat organlari, chet davlatlar, xalqaro va boshqa tashkilotlar bilan o‘zaro munosabatlarda Qonunchilik palatasi nomidan ish ko‘radi;\n" +
                        "7) Qonunchilik palatasi qarorlarini imzolaydi;\n" +
                        "8) ushbu Konstitutsiya va qonun hujjatlarida nazarda tutilgan boshqa vakolatlarni amalga oshiradi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi Spikeri farmoyishlar chiqaradi.")
        )
        substance18.add(
            Substance(
                "101-modda",
                "O‘zbekiston Respublikasi Oliy Majlisining Senati o‘z tarkibidan Senat Raisi va uning o‘rinbosarlarini saylaydi. Senat Raisi O‘zbekiston Respublikasi Prezidentining taqdimiga binoan saylanadi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati Raisi o‘rinbosarlaridan biri Qoraqalpog‘iston Respublikasining vakili bo‘ladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati Raisi va uning o‘rinbosarlari yashirin ovoz berish orqali senatorlar umumiy sonining ko‘pchilik ovozi bilan Senat vakolati muddatiga saylanadi.\n" +
                        "Ayni bir shaxs surunkasiga ikki muddatdan ortiq O‘zbekiston Respublikasi Oliy Majlisi Senatining Raisi bo‘lishi mumkin emas.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati Raisi va uning o‘rinbosarlari yashirin ovoz berish orqali senatorlar umumiy sonining uchdan ikki qismidan ko‘prog‘ining ovozi bilan qabul qilingan Senat qaroriga binoan muddatidan ilgari chaqirib olinishi mumkin.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati Raisi:\n" +
                        "1) Senat majlislarini chaqiradi, ularda raislik qiladi;\n" +
                        "2) Senat muhokamasiga kiritiladigan masalalarni tayyorlashga umumiy rahbarlik qiladi;\n" +
                        "3) Senat qo‘mitalari va komissiyalarining faoliyatini muvofiqlashtirib boradi;\n" +
                        "4) O‘zbekiston Respublikasi qonunlarining va Senat qarorlarining ijrosi ustidan nazoratni tashkil etadi;\n" +
                        "5) parlamentlararo aloqalarni amalga oshirish ishlariga hamda xalqaro parlament tashkilotlari ishi bilan bog‘liq Senat guruhlarining faoliyatiga rahbarlik qiladi;\n" +
                        "6) O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi, boshqa davlat organlari, chet davlatlar, xalqaro va boshqa tashkilotlar bilan o‘zaro munosabatlarda Senat nomidan ish ko‘radi;\n" +
                        "7) Senat qarorlarini imzolaydi;\n" +
                        "8) ushbu Konstitutsiya va qonun hujjatlarida nazarda tutilgan boshqa vakolatlarni amalga oshiradi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Senati Raisi farmoyishlar chiqaradi.")
        )
        substance18.add(Substance("102-modda","O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi qonun loyihalarini tayyorlash ishini olib borish, Qonunchilik palatasi muhokamasiga kiritiladigan masalalarni dastlabki tarzda ko‘rib chiqish va tayyorlash, O‘zbekiston Respublikasi qonunlari hamda Qonunchilik palatasi tomonidan qabul qilinadigan qarorlarning ijrosini nazorat qilish uchun o‘z vakolatlari muddatiga Qonunchilik palatasi deputatlari orasidan qo‘mitalarni saylaydi.\n" +
                "O‘zbekiston Respublikasi Oliy Majlisining Senati Senat muhokamasiga kiritiladigan masalalarni dastlabki tarzda ko‘rib chiqish va tayyorlash, O‘zbekiston Respublikasi qonunlari hamda Senat tomonidan qabul qilinadigan qarorlarning ijrosini nazorat qilish uchun o‘z vakolatlari muddatiga senatorlar orasidan qo‘mitalarni saylaydi.\n" +
                "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi va Senati, zarurat bo‘lgan taqdirda, muayyan vazifalarni bajarish uchun deputatlar, senatorlar orasidan komissiyalar tuzadi."))

        substance18.add(Substance("109-modda","Mamlakatning xavfsizligi, barqaror rivojlanishi asoslariga salbiy ta’sir ko‘rsatishi mumkin bo‘lgan, inson huquqlari va erkinliklariga, jamiyat va davlat manfaatlariga tahdid soladigan faktlar va voqealarni o‘rganish maqsadida O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasi va Senatining qo‘shma qarori bilan parlament tekshiruvi o‘tkazilishi mumkin.\n" +
                "Parlament tekshiruvini o‘tkazish uchun O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasi deputatlari va Senati a’zolari orasidan tenglik asosida maxsus komissiya tuzilib, u o‘z faoliyatini qonunga muvofiq amalga oshiradi."))

        substance18.add(Substance("104-modda","O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputatlariga va Senati a’zolariga ularning deputatlik yoki senatorlik faoliyati bilan bog‘liq xarajatlar belgilangan tartibda qoplanadi.\n" +
                "Qonunchilik palatasi deputatlari hamda Senatda doimiy asosda ishlovchi Senat a’zolari o‘z vakolatlari davrida ilmiy, ijodiy va pedagogik faoliyatdan tashqari haq to‘lanadigan boshqa turdagi faoliyat bilan shug‘ullanishlari mumkin emas.\n" +
                "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputati va Senati a’zosi daxlsizlik huquqidan foydalanadilar. Ular tegishincha Qonunchilik palatasi yoki Senatning roziligisiz jinoiy javobgarlikka tortilishi, ushlab turilishi, qamoqqa olinishi yoki sud tartibida beriladigan ma’muriy jazo choralariga tortilishi mumkin emas."))


        chap5.add(Chap("XVIII bob. O‘zbekiston Respublikasi Oliy Majlisi",substance18))


        val substance19=ArrayList<Substance>()
        substance19.add(Substance("105-modda","O‘zbekiston Respublikasining Prezidenti davlat boshlig‘idir va davlat hokimiyati organlarining kelishilgan holda faoliyat yuritishini hamda hamkorligini ta’minlaydi."))

        substance19.add(Substance("106-modda","O‘zbekiston Respublikasi Prezidenti lavozimiga o‘ttiz besh yoshdan kichik bo‘lmagan, davlat tilini yaxshi biladigan, bevosita saylovgacha kamida 10 yil O‘zbekiston hududida muqim yashayotgan O‘zbekiston Respublikasi fuqarosi saylanishi mumkin. Ayni bir shaxs surunkasiga ikki muddatdan ortiq O‘zbekiston Respublikasining Prezidenti bo‘lishi mumkin emas.\n" +
                "O‘zbekiston Respublikasining Prezidenti O‘zbekiston Respublikasining fuqarolari tomonidan umumiy, teng va to‘g‘ridan to‘g‘ri saylov huquqi asosida yashirin ovoz berish yo‘li bilan yetti yil muddatga saylanadi. O‘zbekiston Respublikasining Prezidentini saylash tartibi qonun bilan belgilanadi."))

        substance19.add(Substance("107-modda","O‘zbekiston Respublikasi Prezidenti o‘z vazifasini bajarib turgan davrda boshqa haq to‘lanadigan lavozimni egallashi, vakillik organining deputati bo‘lishi, tadbirkorlik faoliyati bilan shug‘ullanishi mumkin emas.\n" +
                "O‘zbekiston Respublikasi Prezidentining shaxsi daxlsizdir va qonun bilan muhofaza etiladi."))

        substance19.add(Substance("108-modda","O‘zbekiston Respublikasi Prezidenti O‘zbekiston Respublikasi Oliy Majlisi yig‘ilishida quyidagi qasamyodni qabul qilgan paytdan boshlab o‘z lavozimiga kirishgan hisoblanadi:\n" +
                "“O‘zbekiston xalqiga sadoqat bilan xizmat qilishga, respublikaning Konstitutsiyasi va qonunlariga qat’iy rioya etishga, fuqarolarning huquqlari va erkinliklariga kafolat berishga, O‘zbekiston Respublikasi Prezidenti zimmasiga yuklatilgan vazifalarni vijdonan bajarishga tantanali qasamyod qilaman”."))

        substance19.add(Substance("109-modda","O‘zbekiston Respublikasining Prezidenti:\n" +
                "1) fuqarolarning huquqlari va erkinliklariga, O‘zbekiston Respublikasining Konstitutsiyasi va qonunlariga rioya etilishining, O‘zbekiston Respublikasi suvereniteti, xavfsizligi va hududiy yaxlitligining kafilidir, milliy-davlat tuzilishi masalalariga doir qarorlarni amalga oshirish yuzasidan zarur chora-tadbirlar ko‘radi;\n" +
                "2) mamlakat ichkarisida va xalqaro munosabatlarda O‘zbekiston Respublikasi nomidan ish ko‘radi;\n" +
                "3) muzokaralar olib boradi hamda O‘zbekiston Respublikasining shartnoma va bitimlarini imzolaydi, respublika tomonidan tuzilgan shartnomalarga, bitimlarga va uning qabul qilingan majburiyatlariga rioya etilishini ta’minlaydi;\n" +
                "4) o‘z huzurida akkreditatsiyadan o‘tgan diplomatik hamda boshqa vakillarning ishonch va chaqiruv yorliqlarini qabul qiladi;\n" +
                "5) O‘zbekiston Respublikasining chet davlatlardagi va xalqaro tashkilotlar huzuridagi diplomatik hamda boshqa vakolatxonalarining rahbarlarini tayinlash uchun nomzodlarni O‘zbekiston Respublikasi Oliy Majlisining Senatiga taqdim etadi;\n" +
                "6) O‘zbekiston Respublikasi xalqiga hamda Oliy Majlisiga mamlakat ichki va tashqi siyosatini amalga oshirishning eng muhim masalalari yuzasidan murojaat qilish huquqiga ega;\n" +
                "7) vazirliklarni va boshqa respublika ijro etuvchi hokimiyat organlarini tuzadi hamda tugatadi, shu masalalarga doir farmonlarni keyinchalik O‘zbekiston Respublikasi Oliy Majlisining Senati tasdig‘iga kiritadi;\n" +
                "8) Senat Raisi lavozimiga saylash uchun nomzodni O‘zbekiston Respublikasi Oliy Majlisining Senatiga taqdim etadi;\n" +
                "9) O‘zbekiston Respublikasi Bosh vazirini, O‘zbekiston Respublikasi Vazirlar Mahkamasi a’zolarini O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi ma’qullaganidan keyin lavozimga tayinlaydi va ularni lavozimidan ozod etadi;\n" +
                "10) qo‘mitalar, agentliklar va boshqa respublika davlat organlari rahbarlarini qonunchilikka muvofiq lavozimga tayinlaydi va lavozimidan ozod etadi;\n" +
                "11) O‘zbekiston Respublikasi Bosh prokurorini, O‘zbekiston Respublikasi Hisob palatasi raisini O‘zbekiston Respublikasi Oliy Majlisining Senati ma’qullaganidan keyin lavozimga tayinlaydi va ularni lavozimidan ozod etadi;\n" +
                "12) O‘zbekiston Respublikasi Oliy Majlisining Senati bilan maslahatlashuvlardan keyin O‘zbekiston Respublikasi Davlat xavfsizlik xizmati raisini lavozimga tayinlaydi va uni lavozimidan ozod etadi;\n" +
                "13) O‘zbekiston Respublikasi Oliy Majlisining Senatiga O‘zbekiston Respublikasi Konstitutsiyaviy sudi, O‘zbekiston Respublikasi Oliy sudi, O‘zbekiston Respublikasi Sudyalar oliy kengashi tarkiblariga nomzodlarni, shuningdek O‘zbekiston Respublikasi Markaziy banki boshqaruvining raisi, respublika korrupsiyaga qarshi kurashish organining rahbari va respublika monopoliyaga qarshi organining rahbari lavozimlariga nomzodlarni taqdim etadi;\n" +
                "14) O‘zbekiston Respublikasi Sudyalar oliy kengashining taqdimiga binoan viloyatlar va Toshkent shahar sudlari raislarini va rais o‘rinbosarlarini, O‘zbekiston Respublikasi Harbiy sudi raisini tayinlaydi va lavozimidan ozod etadi;\n" +
                "15) viloyatlar hokimlarini va Toshkent shahar hokimini tayinlaydi hamda lavozimidan ozod etadi. Konstitutsiyani, qonunlarni buzgan yoki hokim sha’ni va qadr-qimmatiga dog‘ tushiradigan xatti-harakat sodir etgan tuman va shahar hokimlarini O‘zbekiston Respublikasi Prezidenti o‘z qarori bilan lavozimidan ozod etishga haqli;\n" +
                "16) respublika ijro etuvchi hokimiyat organlarining va hokimlarning hujjatlarini to‘xtatadi, bekor qiladi; O‘zbekiston Respublikasi Vazirlar Mahkamasi majlislarida raislik qilishga haqli;\n" +
                "17) O‘zbekiston Respublikasining qonunlarini imzolaydi va e’lon qiladi; qonunni o‘z e’tirozlari bilan takroran muhokama qilish va ovozga qo‘yish uchun O‘zbekiston Respublikasi Oliy Majlisiga qaytarishga haqli;\n" +
                "18) O‘zbekiston Respublikasiga hujum qilinganda yoki tajovuzdan bir-birini mudofaa qilish yuzasidan tuzilgan shartnoma majburiyatlarini bajarish zaruriyati tug‘ilganda urush holati, umumiy yoki qisman safarbarlik e’lon qiladi va qabul qilgan qarorini uch kun ichida O‘zbekiston Respublikasi Oliy Majlisi palatalarining tasdig‘iga kiritadi;\n" +
                "19) alohida hollarda (real tashqi xavf, ommaviy tartibsizliklar, yirik halokat, tabiiy ofat, epidemiyalar) fuqarolarning xavfsizligini ta’minlashni ko‘zlab, O‘zbekiston Respublikasining butun hududida yoki uning ayrim joylarida favqulodda holat joriy etadi va qabul qilgan qarorini uch kun ichida O‘zbekiston Respublikasi Oliy Majlisining palatalari tasdig‘iga kiritadi. Favqulodda holat joriy etish shartlari va tartibi qonun bilan belgilanadi;\n" +
                "20) O‘zbekiston Respublikasi Qurolli Kuchlarining Oliy Bosh qo‘mondoni hisoblanadi, Qurolli Kuchlarning oliy qo‘mondonlarini tayinlaydi va lavozimidan ozod etadi, oliy harbiy unvonlar beradi;\n" +
                "21) O‘zbekiston Respublikasining ordenlari, medallari va yorlig‘i bilan mukofotlaydi, O‘zbekiston Respublikasining malakaviy va faxriy unvonlarini beradi;\n" +
                "22) O‘zbekiston Respublikasining fuqaroligiga va siyosiy boshpana berishga oid masalalarni hal etadi;\n" +
                "23) amnistiya to‘g‘risidagi hujjatlarni qabul qilish haqida O‘zbekiston Respublikasi Oliy Majlisining Senatiga taqdimnomalar kiritadi va O‘zbekiston Respublikasining sudlari tomonidan hukm qilingan shaxslarni afv etadi;\n" +
                "24) O‘zbekiston Respublikasi Prezidenti huzuridagi Xavfsizlik kengashini tuzadi va unga boshchilik qiladi, o‘z vakolatlari amalga oshirilishini ta’minlash maqsadida O‘zbekiston Respublikasi Prezidenti Administratsiyasini, shuningdek O‘zbekiston Respublikasi Prezidenti huzuridagi maslahat-kengash organlarini va boshqa organlarni shakllantiradi;\n" +
                "25) ushbu Konstitutsiya va qonunlarda nazarda tutilgan boshqa vakolatlarni amalga oshiradi.\n" +
                "O‘zbekiston Respublikasi Prezidenti o‘z vakolatlarini bajarishni davlat organlariga yoki mansabdor shaxslarga topshirishga haqli emas."))


        substance19.add(Substance("110-modda","O‘zbekiston Respublikasining Prezidenti Konstitutsiyaga va qonunlarga asoslanib hamda ularni ijro etish yuzasidan respublikaning butun hududida majburiy kuchga ega bo‘lgan farmonlar, qarorlar va farmoyishlar chiqaradi."))

        substance19.add(
            Substance(
                "111-modda",
                "Qonunchilik palatasi yoki Senat tarkibida ularning normal faoliyatiga tahdid soluvchi hal qilib bo‘lmaydigan ixtiloflar yuz berganda yoxud ular bir necha marta O‘zbekiston Respublikasining Konstitutsiyasiga zid qarorlar qabul qilgan taqdirda, shuningdek Qonunchilik palatasi bilan Senat o‘rtasida O‘zbekiston Respublikasi Oliy Majlisining normal faoliyatiga tahdid soluvchi hal qilib bo‘lmaydigan ixtiloflar yuz berganda O‘zbekiston Respublikasi Prezidentining O‘zbekiston Respublikasi Konstitutsiyaviy sudi bilan bamaslahat qabul qilgan qarori asosida O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi, Senati tarqatib yuborilishi mumkin.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi, Senati tarqatib yuborilgan taqdirda yangi saylov uch oy mobaynida o‘tkaziladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi va Senati favqulodda holat amal qilishi davrida tarqatib yuborilishi mumkin emas.")
        )

        substance19.add(Substance("112-modda","O‘zbekiston Respublikasining amaldagi Prezidenti o‘z vazifalarini bajara olmaydigan holatlarda uning vazifa va vakolatlari vaqtincha O‘zbekiston Respublikasi Oliy Majlisi Senati Raisining zimmasiga yuklatiladi, bunda uch oy muddat ichida qonunga to‘liq muvofiq holda O‘zbekiston Respublikasi Prezidenti saylovi o‘tkaziladi."))

        substance19.add(Substance("113-modda","Vakolati tugashi munosabati bilan iste’foga chiqqan O‘zbekiston Respublikasi Prezidenti umrbod O‘zbekiston Respublikasi Oliy Majlisi Senati a’zosi lavozimini egallaydi."))



        chap5.add(Chap("XIX bob. O‘zbekiston Respublikasining Prezidenti",substance19))


        val substance20=ArrayList<Substance>()
        substance20.add(
            Substance(
                "114-modda",
                "O‘zbekiston Respublikasi Vazirlar Mahkamasi ijro etuvchi hokimiyatni amalga oshiradi. O‘zbekiston Respublikasi Vazirlar Mahkamasi O‘zbekiston Respublikasi Bosh vaziri, uning o‘rinbosarlari va vazirlardan iborat. Qoraqalpog‘iston Respublikasi hukumatining boshlig‘i Vazirlar Mahkamasi tarkibiga o‘z lavozimi bo‘yicha kiradi.\n" +
                        "Vazirlar Mahkamasi o‘z faoliyatini ijro etuvchi hokimiyat faoliyatining O‘zbekiston Respublikasi Prezidenti tomonidan belgilanadigan asosiy yo‘nalishlari doirasida amalga oshiradi.")
        )

        substance20.add(Substance("115-modda","O‘zbekiston Respublikasi Vazirlar Mahkamasi:\n" +
                "1) samarali iqtisodiy, ijtimoiy, soliq va budjet siyosati amalga oshirilishi, ilm-fan, madaniyat, ta’lim, sog‘liqni saqlashni hamda iqtisodiyotning va ijtimoiy sohaning boshqa tarmoqlarini rivojlantirishga doir dasturlarning ishlab chiqilishi hamda bajarilishi uchun javobgar bo‘ladi;\n" +
                "2) barqaror iqtisodiy o‘sishni, makroiqtisodiy barqarorlikni ta’minlash, kambag‘allikni qisqartirish, aholi uchun munosib turmush sharoitlarini yaratish, oziq-ovqat xavfsizligini ta’minlash, qulay investitsiyaviy muhitni yaratish, hududlarni kompleks va barqaror rivojlantirish bo‘yicha choralar ko‘radi;\n" +
                "3) aholini, shu jumladan nogironligi bo‘lgan shaxslarni ijtimoiy himoya qilish tizimining samarali faoliyat ko‘rsatishini ta’minlaydi;\n" +
                "4) atrof-muhitni muhofaza qilish, tabiiy boyliklarni va biologik xilma-xillikni saqlash, iqlim o‘zgarishiga, epidemiyalarga, pandemiyalarga qarshi kurashish hamda ularning oqibatlarini yumshatish sohalarida yagona davlat siyosati amalga oshirilishini ta’minlaydi;\n" +
                "5) yoshlarga oid davlat siyosatining amalga oshirilishini ta’minlaydi, oilani qo‘llab-quvvatlash, mustahkamlash va himoya qilish, an’anaviy oilaviy qadriyatlarni saqlash bo‘yicha choralar ko‘radi;\n" +
                "6) fuqarolik jamiyati institutlarini qo‘llab-quvvatlash chora-tadbirlarini amalga oshiradi, ijtimoiy-iqtisodiy rivojlantirish hamda ijtimoiy sheriklik dasturlarini ishlab chiqish va amalga oshirishda ularning ishtirok etishini ta’minlaydi;\n" +
                "7) fuqarolarning iqtisodiy, ijtimoiy hamda boshqa huquqlari va qonuniy manfaatlarini himoya qilish bo‘yicha chora-tadbirlarni amalga oshiradi;\n" +
                "8) O‘zbekiston Respublikasi Konstitutsiyasi va qonunlari, Oliy Majlis palatalari qarorlari, O‘zbekiston Respublikasi Prezidenti farmonlari, qarorlari va farmoyishlari ijrosini ta’minlaydi;\n" +
                "9) ijro etuvchi hokimiyat organlari ishini muvofiqlashtiradi va yo‘naltiradi, ularning faoliyati ustidan qonunda belgilangan tartibda nazoratni amalga oshiradi;\n" +
                "10) ijro etuvchi hokimiyat organlarining ishida ochiqlik va shaffoflikni, qonuniylik va samaradorlikni ta’minlash, ularning faoliyatida korrupsiya holatlariga qarshi kurashish, davlat xizmatlarining sifatini oshirish va ulardan foydalanish imkoniyatini kengaytirish bo‘yicha choralar ko‘radi;\n" +
                "11) O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasiga mamlakat ijtimoiy-iqtisodiy hayotining eng muhim masalalari yuzasidan har yilgi ma’ruzalarni taqdim etadi;\n" +
                "12) ushbu Konstitutsiya va qonunlarda nazarda tutilgan boshqa vakolatlarni amalga oshiradi."))


        substance20.add(Substance("116-modda","Vazirlar Mahkamasi konstitutsiyaviy normalar doirasida va qonunchilikka muvofiq O‘zbekiston Respublikasining butun hududidagi barcha organlar, korxonalar, muassasalar, tashkilotlar, mansabdor shaxslar va fuqarolar tomonidan bajarilishi majburiy bo‘lgan qarorlar va farmoyishlar chiqaradi.\n" +
                "Vazirlar Mahkamasi o‘z faoliyatida O‘zbekiston Respublikasi Oliy Majlisi va O‘zbekiston Respublikasi Prezidenti oldida javobgardir.\n" +
                "Amaldagi Vazirlar Mahkamasi yangi saylangan O‘zbekiston Respublikasi Oliy Majlisi oldida o‘z vakolatlarini zimmasidan soqit qiladi, biroq Vazirlar Mahkamasining yangi tarkibi shakllantirilguniga qadar O‘zbekiston Respublikasi Prezidentining qaroriga muvofiq o‘z faoliyatini davom ettirib turadi."))

        substance20.add(Substance("117-modda","O‘zbekiston Respublikasi Bosh vaziri:\n" +
                "1) Vazirlar Mahkamasi faoliyatini tashkil etadi va unga rahbarlik qiladi, uning samarali ishlashi uchun shaxsan javobgar bo‘ladi;\n" +
                "2) Vazirlar Mahkamasining majlislarida raislik qiladi, uning qarorlarini imzolaydi;\n" +
                "3) xalqaro munosabatlarda O‘zbekiston Respublikasi Vazirlar Mahkamasi nomidan ish ko‘radi;\n" +
                "4) O‘zbekiston Respublikasi qonunlarida nazarda tutilgan boshqa vazifalarni bajaradi."))

        substance20.add(
            Substance(
                "118-modda",
                "O‘zbekiston Respublikasi Bosh vaziri nomzodi O‘zbekiston Respublikasi Oliy Majlisi palatalarining mansabdor shaxslari saylangandan va organlari shakllangandan so‘ng bir oy ichida yoki Bosh vazir lavozimidan ozod etilganidan keyin yoxud Bosh vazir, Vazirlar Mahkamasining amaldagi tarkibi iste’foga chiqqanidan keyin bir oy ichida Qonunchilik palatasi ko‘rib chiqishi va ma’qullashi uchun O‘zbekiston Respublikasi Prezidenti tomonidan barcha siyosiy partiyalar fraksiyalari bilan maslahatlashuvlar o‘tkazilganidan so‘ng taqdim etiladi.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi O‘zbekiston Respublikasi Prezidenti tomonidan taqdim etilgan O‘zbekiston Respublikasi Bosh vaziri nomzodini taqdimnoma kiritilgan kundan e’tiboran o‘n kun ichida ko‘rib chiqadi.\n" +
                        "Bosh vazir lavozimiga nomzod O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasida uning nomzodi ko‘rib chiqilayotganda Vazirlar Mahkamasining yaqin muddatga va uzoq istiqbolga mo‘ljallangan harakat dasturini taqdim etadi.\n" +
                        "Bosh vazir nomzodi uning uchun O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputatlari umumiy sonining yarmidan ko‘pi tomonidan ovoz berilgan taqdirda ma’qullangan hisoblanadi.\n" +
                        "Bosh vazir lavozimiga taqdim etilgan nomzod uch marta rad etilgan taqdirda, O‘zbekiston Respublikasi Prezidenti Bosh vazirni tayinlaydi va O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasini tarqatib yuborishga haqli.\n" +
                        "O‘zbekiston Respublikasi Vazirlar Mahkamasining a’zolari ularning nomzodlari O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi tomonidan ma’qullanganidan keyin O‘zbekiston Respublikasi Prezidenti tomonidan lavozimga tayinlanadi.\n" +
                        "O‘zbekiston Respublikasi Prezidenti Bosh vazirni, O‘zbekiston Respublikasi Vazirlar Mahkamasining amaldagi tarkibini yoki a’zosini iste’foga chiqarishga haqli.\n" +
                        "O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi O‘zbekiston Respublikasi Vazirlar Mahkamasi a’zosining o‘z faoliyatiga oid masalalar yuzasidan hisobotini eshitishga haqli. Vazirlar Mahkamasi a’zosining hisobotini eshitish yakunlariga ko‘ra Qonunchilik palatasi uni iste’foga chiqarish to‘g‘risidagi taklifni O‘zbekiston Respublikasi Prezidentiga ko‘rib chiqish uchun kiritishga haqli.\n" +
                        "O‘zbekiston Respublikasi Vazirlar Mahkamasi a’zolari parlament so‘rovlariga va Qonunchilik palatasi deputatining, Senat a’zosining so‘rovlariga qonunda belgilangan tartibda javob berishi shart.\n" +
                        "Vazirlar Mahkamasining faoliyatini tashkil etish tartibi va vakolat doirasi qonun bilan belgilanadi.")
        )

        substance20.add(
            Substance(
                "119-modda",
                "O‘zbekiston Respublikasi Bosh vaziri va O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi o‘rtasida ziddiyatlar doimiy tus olgan holda Qonunchilik palatasi deputatlari umumiy sonining kamida uchdan bir qismi tomonidan O‘zbekiston Respublikasi Prezidenti nomiga rasman kiritilgan taklif bo‘yicha O‘zbekiston Respublikasi Oliy Majlisi Qonunchilik palatasining muhokamasiga Bosh vazirga nisbatan ishonchsizlik votumi bildirish haqidagi masala kiritiladi.\n" +
                        "Bosh vazirga nisbatan ishonchsizlik votumi, agar O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputatlari umumiy sonining kamida uchdan ikki qismi ovoz bersa, qabul qilingan hisoblanadi. Bunday holatda O‘zbekiston Respublikasi Prezidenti Bosh vazirni lavozimidan ozod etish to‘g‘risida qaror qabul qiladi. Bunda O‘zbekiston Respublikasi Vazirlar Mahkamasining butun tarkibi Bosh vazir bilan birga iste’foga chiqadi.")
        )


        chap5.add(Chap("XX bob. O‘zbekiston Respublikasi Vazirlar Mahkamasi",substance20))

        val substance21=ArrayList<Substance>()

        substance21.add(Substance("120-modda","Viloyatlar, tumanlar va shaharlarda (tumanga bo‘ysunadigan shaharlardan tashqari) xalq deputatlari Kengashlari davlat hokimiyati vakillik organlaridir.\n" +
                "Xalq deputatlari Kengashiga uning deputatlari orasidan qonunga muvofiq saylanadigan rais boshchilik qiladi.\n" +
                "Viloyat, tuman, shahar hokimi lavozimini egallab turgan shaxs bir vaqtning o‘zida xalq deputatlari Kengashining raisi lavozimini egallashi mumkin emas.\n" +
                "Xalq deputatlari Kengashlarining vakolatlari muddati — besh yil. Ayni bir shaxs surunkasiga ikki muddatdan ortiq ayni bir viloyat, tuman, shahar xalq deputatlari Kengashining raisi etib saylanishi mumkin emas.\n" +
                "Xalq deputatlari Kengashlari deputatlari saylovi va xalq deputatlari Kengashlarining faoliyatini tashkil etish tartibi qonun bilan belgilanadi.\n" +
                "Yangidan tashkil etilgan ma’muriy-hududiy birliklarda xalq deputatlari Kengashlariga saylov xalq deputatlari Kengashlariga navbatdagi umumiy saylovlarga qadar qolgan davrdan oshmaydigan muddatga o‘tkaziladi."))

        substance21.add(
            Substance(
                "121-modda",
                "Tegishli hududdagi ijro etuvchi hokimiyatga viloyat, tuman va shahar hokimi boshchilik qiladi.\n" +
                        "Hokimlarning vakolatlari muddati — besh yil. Ayni bir shaxs surunkasiga ikki muddatdan ortiq ayni bir viloyat, tuman, shaharning hokimi etib tayinlanishi mumkin emas.\n" +
                        "Hokimlarning faoliyatini tashkil etish tartibi qonun bilan belgilanadi.")
        )

        substance21.add(
            Substance(
                "122-modda",
                "Xalq deputatlari Kengashlarining vakolatlari quyidagilardan iborat:\n" +
                        "1) tegishli mahalliy budjetlarni ko‘rib chiqish va qabul qilish, ularning ijro etilishi ustidan nazoratni amalga oshirish;\n" +
                        "2) hududlarni ijtimoiy-iqtisodiy rivojlantirish va aholini ijtimoiy himoya qilish dasturlarini tasdiqlash;\n" +
                        "3) hokimni lavozimga tasdiqlash, uning faoliyati to‘g‘risidagi hisobotlarni eshitish;\n" +
                        "4) ushbu Konstitutsiya va qonunlarda nazarda tutilgan boshqa vakolatlarni amalga oshirish.")
        )
        substance21.add(
            Substance(
                "123-modda",
                "Viloyatlar, tumanlar, shaharlar hokimlarining vakolatlari quyidagilardan iborat:\n" +
                        "1) O‘zbekiston Respublikasining Konstitutsiyasi va qonunlarini, Oliy Majlis palatalarining qarorlarini, O‘zbekiston Respublikasi Prezidentining farmonlari, qarorlari hamda farmoyishlarini, Vazirlar Mahkamasining, yuqori turuvchi hokimlarning va tegishli xalq deputatlari Kengashlarining qarorlarini bajarish;\n" +
                        "2) hududlarni iqtisodiy, ijtimoiy, madaniy va ekologik jihatdan rivojlantirishni ta’minlashga qaratilgan chora-tadbirlarni amalga oshirish;\n" +
                        "3) mahalliy budjetni shakllantirish va ijro etish;\n" +
                        "4) ushbu Konstitutsiya va qonunlarda nazarda tutilgan boshqa vakolatlarni amalga oshirish.")
        )
        substance21.add(
            Substance(
                "124-modda",
                "Viloyat va Toshkent shahar hokimi O‘zbekiston Respublikasi Prezidenti tomonidan qonunga muvofiq tayinlanadi va lavozimidan ozod etiladi.\n" +
                        "Tuman va shaharlarning hokimlari viloyat, Toshkent shahar hokimi tomonidan tayinlanadi va lavozimidan ozod etiladi hamda tegishli xalq deputatlari Kengashi tomonidan tasdiqlanadi.\n" +
                        "Tumanga bo‘ysunadigan shaharlarning hokimlari tuman hokimi tomonidan tayinlanadi va lavozimidan ozod etiladi hamda xalq deputatlari tuman Kengashi tomonidan tasdiqlanadi.")
        )

        substance21.add(
            Substance(
                "125-modda",
                "Viloyat, tuman va shahar hokimi o‘z vakolatlarini yakkaboshchilik asosida amalga oshiradi hamda o‘zi rahbarlik qilayotgan organlarning qarorlari va harakatlari uchun shaxsan javobgar bo‘ladi.\n" +
                        "Viloyat, tuman va shahar hokimi tegishli xalq deputatlari Kengashiga viloyatni, tumanni, shaharni ijtimoiy-iqtisodiy rivojlantirishning eng muhim va dolzarb masalalari yuzasidan hisobotlar taqdim etadi, ushbu hisobotlar bo‘yicha xalq deputatlari Kengashi tomonidan tegishli qarorlar qabul qilinadi.")
        )


        substance21.add(Substance("126-modda","Xalq deputatlari Kengashi va hokim o‘z vakolatlari doirasida tegishli hududdagi barcha tashkilotlar, shuningdek mansabdor shaxslar va fuqarolar tomonidan bajarilishi majburiy bo‘lgan qarorlar qabul qiladi."))

        substance21.add(Substance("127-modda","Shaharchalar, qishloqlar va ovullarda, shuningdek shaharlar, shaharchalar, qishloqlar va ovullardagi mahallalarda fuqarolarning yig‘inlari o‘zini o‘zi boshqarish organlari bo‘lib, ular raisni saylaydi.\n" +
                "Fuqarolarning o‘zini o‘zi boshqarish organlari davlat hokimiyati organlari tizimiga kirmaydi hamda mahalliy ahamiyatga molik masalalarni fuqarolarning manfaatlaridan, rivojlanishning tarixiy o‘ziga xos xususiyatlaridan, shuningdek milliy qadriyatlardan, mahalliy urf-odatlar va an’analardan kelib chiqqan holda, qonunga muvofiq mustaqil ravishda hal etishga haqli.\n" +
                "Davlat fuqarolarning o‘zini o‘zi boshqarish organlari faoliyatini amalga oshirishi uchun zarur shart-sharoitlar yaratadi, ularga qonunda belgilangan vakolatlarini amalga oshirishida ko‘maklashadi.\n" +
                "Fuqarolarning o‘zini o‘zi boshqarish organlari saylovi tartibi, ularning faoliyatini tashkil etish va vakolatlari qonun bilan belgilanadi."))



        chap5.add(Chap("XXI bob. Mahalliy davlat hokimiyati asoslari. Fuqarolarning o‘zini o‘zi boshqarish organlari",substance21))

        val substance22=ArrayList<Substance>()

        substance22.add(Substance("128-modda","O‘zbekiston Respublikasining fuqarolari davlat hokimiyati vakillik organlariga saylash va saylanish huquqiga egadirlar. Har bir saylovchi bir ovozga ega. Ovoz berish huquqi, o‘z xohish-irodasini bildirish tengligi va erkinligi qonun bilan kafolatlanadi.\n" +
                "O‘zbekiston Respublikasi Prezidenti saylovi, O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasiga hamda Qoraqalpog‘iston Respublikasi Jo‘qorg‘i Kengesiga, viloyatlar, tumanlar, shaharlar davlat hokimiyati vakillik organlariga saylov tegishincha ularning konstitutsiyaviy vakolat muddati tugaydigan yilda — oktyabr oyi uchinchi o‘n kunligining birinchi yakshanbasida o‘tkaziladi, bundan ushbu Konstitutsiyada nazarda tutilgan muddatidan ilgari saylov o‘tkazish hollari mustasno. Saylovlar umumiy, teng va to‘g‘ridan to‘g‘ri saylov huquqi asosida yashirin ovoz berish yo‘li bilan o‘tkaziladi. O‘zbekiston Respublikasining o‘n sakkiz yoshga to‘lgan fuqarolari saylash huquqiga ega.\n" +
                "O‘zbekiston Respublikasi Prezidenti muddatidan ilgari O‘zbekiston Respublikasi Prezidenti saylovini tayinlashga haqli.\n" +
                "O‘zbekiston Respublikasi Oliy Majlisining Senati a’zolari Qoraqalpog‘iston Respublikasi Jo‘qorg‘i Kengesi, viloyatlar, tumanlar va shaharlar davlat hokimiyati vakillik organlari deputatlarining tegishli qo‘shma majlislarida mazkur deputatlar saylanganidan so‘ng bir oy ichida ular orasidan yashirin ovoz berish yo‘li bilan saylanadilar.\n" +
                "Sud tomonidan muomalaga layoqatsiz deb topilgan fuqarolar, shuningdek sud hukmi bilan ozodlikdan mahrum etish joylarida saqlanayotgan shaxslar saylanishi mumkin emas.\n" +
                "Sud tomonidan muomalaga layoqatsiz deb topilgan fuqarolar, shuningdek og‘ir va o‘ta og‘ir jinoyatlar sodir etganlik uchun sudning hukmiga ko‘ra ozodlikdan mahrum etish joylarida saqlanayotgan shaxslar saylovda ishtirok etish huquqidan faqat qonunga muvofiq hamda sudning qarori asosida mahrum etilishi mumkin. Boshqa har qanday hollarda fuqarolarning saylov huquqlarini to‘g‘ridan to‘g‘ri yoki bilvosita cheklashga yo‘l qo‘yilmaydi.\n" +
                "O‘zbekiston Respublikasi fuqarosi bir vaqtning o‘zida ikkidan ortiq davlat hokimiyati vakillik organining deputati bo‘lishi mumkin emas.\n" +
                "Saylov o‘tkazish tartibi qonun bilan belgilanadi."))

        substance22.add(Substance("129-modda","O‘zbekiston Respublikasi Prezidenti saylovini, O‘zbekiston Respublikasi Oliy Majlisiga, viloyatlar, tumanlar, shaharlar davlat hokimiyati vakillik organlariga saylovlarni, shuningdek O‘zbekiston Respublikasining referendumini tashkil etish va o‘tkazish uchun O‘zbekiston Respublikasi Oliy Majlisi tomonidan faoliyatining asosiy prinsiplari mustaqillik, qonuniylik, kollegiallik, oshkoralik va adolatlilikdan iborat bo‘lgan O‘zbekiston Respublikasi Markaziy saylov komissiyasi tuziladi.\n" +
                "O‘zbekiston Respublikasi Markaziy saylov komissiyasi saylov komissiyalari tizimiga boshchilik qiladi, o‘z faoliyatini doimiy asosda amalga oshiradi hamda o‘z faoliyatida O‘zbekiston Respublikasining Konstitutsiyasiga va qonunlariga amal qiladi.\n" +
                "O‘zbekiston Respublikasi Markaziy saylov komissiyasining a’zolari Qoraqalpog‘iston Respublikasi Jo‘qorg‘i Kengesining, xalq deputatlari viloyatlar va Toshkent shahar Kengashlarining tavsiyasi bo‘yicha O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi va Senati tomonidan saylanadi.\n" +
                "O‘zbekiston Respublikasi Markaziy saylov komissiyasining raisi O‘zbekiston Respublikasi Prezidentining taqdimiga binoan komissiya a’zolari orasidan besh yillik muddatga komissiya majlisida saylanadi. Ayni bir shaxs surunkasiga ikki muddatdan ortiq O‘zbekiston Respublikasi Markaziy saylov komissiyasining raisi etib saylanishi mumkin emas."))

        chap5.add(Chap("XXII bob. Saylov tizimi",substance22))

        val substance23=ArrayList<Substance>()

        substance23.add(Substance("130-modda","O‘zbekiston Respublikasida odil sudlov faqat sud tomonidan amalga oshiriladi.\n" +
                "O‘zbekiston Respublikasida sud hokimiyati qonun chiqaruvchi va ijro etuvchi hokimiyatdan, siyosiy partiyalardan, fuqarolik jamiyatining boshqa institutlaridan mustaqil holda ish yuritadi."))

        substance23.add(Substance("131-modda","O‘zbekiston Respublikasida sud tizimi va sudlar faoliyatining tartibi qonun bilan belgilanadi.\n" +
                "Favqulodda sudlar tuzishga yo‘l qo‘yilmaydi."))

        substance23.add(Substance("132-modda","O‘zbekiston Respublikasi Konstitutsiyaviy sudi qonun chiqaruvchi va ijro etuvchi hokimiyat hujjatlarining Konstitutsiyaga muvofiqligi to‘g‘risidagi ishlarni ko‘radi.\n" +
                "Konstitutsiyaviy sud O‘zbekiston Respublikasi Prezidentining taqdimiga binoan O‘zbekiston Respublikasi Oliy Majlisining Senati tomonidan O‘zbekiston Respublikasi Sudyalar oliy kengashi tavsiya etgan siyosat va huquq sohasidagi mutaxassislar orasidan, Qoraqalpog‘iston Respublikasi vakilini qo‘shgan holda saylanadi.\n" +
                "Konstitutsiyaviy sudning sudyalari qayta saylanish huquqisiz o‘n yillik muddatga saylanadi.\n" +
                "O‘zbekiston Respublikasi Konstitutsiyaviy sudi o‘z tarkibidan O‘zbekiston Respublikasi Konstitutsiyaviy sudining raisini va uning o‘rinbosarini besh yillik muddatga saylaydi."))

        substance23.add(Substance("133-modda","O‘zbekiston Respublikasi Konstitutsiyaviy sudi:\n" +
                "1) O‘zbekiston Respublikasi qonunlarining va O‘zbekiston Respublikasi Oliy Majlisi palatalari qarorlarining, O‘zbekiston Respublikasi Prezidenti farmonlari, qarorlari va farmoyishlarining, hukumat, mahalliy davlat hokimiyati organlari qarorlarining, O‘zbekiston Respublikasi davlatlararo shartnomaviy va boshqa majburiyatlarining O‘zbekiston Respublikasining Konstitutsiyasiga muvofiqligini aniqlaydi;\n" +
                "2) O‘zbekiston Respublikasining Prezidenti tomonidan imzolanguniga qadar — O‘zbekiston Respublikasi konstitutsiyaviy qonunlarining, ratifikatsiya qilish to‘g‘risidagi O‘zbekiston Respublikasi qonunlari O‘zbekiston Respublikasining Prezidenti tomonidan imzolanguniga qadar — O‘zbekiston Respublikasi xalqaro shartnomalarining O‘zbekiston Respublikasi Konstitutsiyasiga muvofiqligini aniqlaydi;\n" +
                "3) referendumga chiqarilayotgan masalalarning O‘zbekiston Respublikasi Konstitutsiyasiga muvofiqligi to‘g‘risida xulosa beradi;\n" +
                "4) Qoraqalpog‘iston Respublikasi Konstitutsiyasining O‘zbekiston Respublikasining Konstitutsiyasiga, Qoraqalpog‘iston Respublikasi qonunlarining O‘zbekiston Respublikasining qonunlariga muvofiqligi to‘g‘risida xulosa beradi;\n" +
                "5) O‘zbekiston Respublikasining Konstitutsiyasi va qonunlari normalariga sharh beradi;\n" +
                "6) O‘zbekiston Respublikasi Oliy sudining muayyan ishda qo‘llanilishi lozim bo‘lgan normativ-huquqiy hujjatlarning O‘zbekiston Respublikasining Konstitutsiyasiga muvofiqligi to‘g‘risida sudlar tashabbusi bilan kiritilgan murojaatini ko‘rib chiqadi;\n" +
                "7) konstitutsiyaviy sudlov ishlarini yuritish amaliyotini umumlashtirish natijalari yuzasidan har yili O‘zbekiston Respublikasi Oliy Majlisi palatalariga va O‘zbekiston Respublikasi Prezidentiga mamlakatdagi konstitutsiyaviy qonuniylikning holati to‘g‘risida axborot taqdim etadi;\n" +
                "8) O‘zbekiston Respublikasining Konstitutsiyasi va qonunlari bilan berilgan vakolati doirasida boshqa ishlarni ko‘rib chiqadi.\n" +
                "Fuqarolar va yuridik shaxslar, agar sud orqali himoya qilishning boshqa barcha vositalaridan foydalanib bo‘lingan bo‘lsa, sudda ko‘rib chiqilishi tugallangan muayyan ishda sud tomonidan o‘ziga nisbatan qo‘llanilgan qonunning Konstitutsiyaga muvofiqligi to‘g‘risidagi shikoyat bilan O‘zbekiston Respublikasi Konstitutsiyaviy sudiga murojaat qilishga haqli.\n" +
                "Konstitutsiyaviy sudning qarori rasmiy e’lon qilingan kundan e’tiboran kuchga kiradi.\n" +
                "Konstitutsiyaviy sudning qarori qat’iy va uning ustidan shikoyat qilinishi mumkin emas.\n" +
                "Konstitutsiyaviy sudni tashkil etish va uning faoliyati tartibi qonun bilan belgilanadi."))

        substance23.add(
            Substance(
                "134-modda",
                "O‘zbekiston Respublikasi Oliy sudi fuqarolik, jinoiy, iqtisodiy va ma’muriy sud ishlarini yuritish sohasida sud hokimiyatining oliy organi hisoblanadi.\n" +
                        "O‘zbekiston Respublikasi Oliy sudi tomonidan qabul qilingan hujjatlar qat’iy hisoblanadi va O‘zbekiston Respublikasining butun hududida bajarilishi majburiydir.\n" +
                        "O‘zbekiston Respublikasi Oliy sudi quyi sudlarning sudlov faoliyati ustidan nazorat olib borish huquqiga ega.\n" +
                        "O‘zbekiston Respublikasi Oliy sudining raisi va uning o‘rinbosarlari O‘zbekiston Respublikasi Prezidentining taqdimiga binoan O‘zbekiston Respublikasi Oliy Majlisining Senati tomonidan besh yillik muddatga saylanadi. Ayni bir shaxs surunkasiga ikki muddatdan ortiq O‘zbekiston Respublikasi Oliy sudining raisi, rais o‘rinbosari etib saylanishi mumkin emas.")
        )
        substance23.add(Substance("135-modda","O‘zbekiston Respublikasi Sudyalar oliy kengashi sudyalar hamjamiyatining mustaqil organi bo‘lib, u sudyalar korpusining shakllantirilishini, sud hokimiyati mustaqilligining konstitutsiyaviy prinsipiga rioya etilishini ta’minlaydi.\n" +
                "O‘zbekiston Respublikasi Sudyalar oliy kengashi raisi va uning o‘rinbosari O‘zbekiston Respublikasi Prezidentining taqdimiga binoan O‘zbekiston Respublikasi Oliy Majlisining Senati tomonidan besh yillik muddatga saylanadi. Ayni bir shaxs surunkasiga ikki muddatdan ortiq O‘zbekiston Respublikasi Sudyalar oliy kengashining raisi, rais o‘rinbosari etib saylanishi mumkin emas.\n" +
                "O‘zbekiston Respublikasi Sudyalar oliy kengashini tashkil etish va uning faoliyati tartibi qonun bilan belgilanadi."))

        substance23.add(
            Substance(
                "136-modda",
                "Sudyalar mustaqildirlar, faqat Konstitutsiya va qonunga bo‘ysunadilar. Sudyalarning odil sudlovni amalga oshirishga doir faoliyatiga har qanday tarzda aralashishga yo‘l qo‘yilmaydi va bunday aralashish qonunga muvofiq javobgarlikka sabab bo‘ladi. Sudyalar muayyan ishlar bo‘yicha hisobdor bo‘lmaydi.\n" +
                        "Sudyalar daxlsizdir.\n" +
                        "Davlat sudyaning va uning oila a’zolarining xavfsizligini ta’minlaydi.\n" +
                        "Sudyani muayyan ishning muhokamasidan chetlashtirishga, uning vakolatlarini bekor qilishga yoki to‘xtatib turishga, boshqa lavozimga o‘tkazishga faqat qonunda belgilangan tartibda va asoslarga ko‘ra yo‘l qo‘yiladi. Sudning qayta tashkil etilishi yoki tugatilishi sudyani lavozimidan ozod etish uchun asos bo‘lib xizmat qilishi mumkin emas.\n" +
                        "Sudyalar senator, davlat hokimiyati vakillik organlarining deputati bo‘lishi mumkin emas.\n" +
                        "Sudyalar siyosiy partiyalarning a’zosi bo‘lishi, siyosiy harakatlarda ishtirok etishi, shuningdek ilmiy, ijodiy va pedagogik faoliyatdan tashqari haq to‘lanadigan boshqa faoliyat turlari bilan shug‘ullanishi mumkin emas.")
        )
        substance23.add(Substance("137-modda","Hamma sudlarda ishlar ochiq ko‘riladi. Ishlarni yopiq majlisda tinglashga qonunda belgilangan hollardagina yo‘l qo‘yiladi."))

        substance23.add(Substance("138-modda","Sud hokimiyatining hujjatlari barcha davlat organlari va boshqa tashkilotlar, mansabdor shaxslar hamda fuqarolar uchun majburiydir."))

        substance23.add(Substance("139-modda","O‘zbekiston Respublikasida sud ishlarini yuritish o‘zbek tilida, qoraqalpoq tilida yoki muayyan joydagi ko‘pchilik aholi so‘zlashadigan tilda yoxud qonunga muvofiq boshqa tilda olib boriladi. Sud ishlari olib borilayotgan tilni bilmaydigan sudda qatnashuvchi shaxslarning tarjimon orqali ish materiallari bilan to‘la tanishish va sud ishlarida ishtirok etish huquqi hamda sudda ona tilida so‘zlash huquqi ta’minlanadi."))

        substance23.add(Substance("140-modda","Sudlarning faoliyatini moliyalashtirish faqat O‘zbekiston Respublikasining Davlat budjetidan amalga oshiriladi hamda u odil sudlovni to‘liq va mustaqil amalga oshirish imkoniyatini ta’minlashi kerak."))



        chap5.add(Chap("XXIII bob. Sud hokimiyati",substance23))

        val substance24=ArrayList<Substance>()
        substance24.add(
            Substance(
                "141-modda",
                "Jismoniy va yuridik shaxslarga malakali yuridik yordam ko‘rsatish uchun advokatura faoliyat ko‘rsatadi.\n" +
                        "Advokatura faoliyati qonuniylik, mustaqillik va o‘zini o‘zi boshqarish prinsiplariga asoslanadi.\n" +
                        "Advokaturani tashkil etish va uning faoliyati tartibi qonun bilan belgilanadi.")
        )
        substance24.add(Substance("142-modda","Advokat o‘z kasbiy vazifalarini amalga oshirayotganda uning faoliyatiga aralashishga yo‘l qo‘yilmaydi.\n" +
                "Advokatga o‘z himoyasidagi shaxs bilan moneliksiz va xoli uchrashish, maslahatlar berish uchun shart-sharoitlar ta’minlanadi.\n" +
                "Advokat, uning sha’ni, qadr-qimmati va kasbiy faoliyati davlat himoyasida bo‘ladi va qonun bilan muhofaza qilinadi."))


        chap5.add(Chap("XXIV bob. Advokatura",substance24))

        val substance25=ArrayList<Substance>()
        substance25.add(Substance("143-modda","O‘zbekiston Respublikasi hududida qonunlarning aniq va bir xilda bajarilishi ustidan nazoratni O‘zbekiston Respublikasining Bosh prokurori va unga bo‘ysunuvchi prokurorlar amalga oshiradi."))

        substance25.add(
            Substance(
                "144-modda",
                "Prokuratura organlarining yagona markazlashtirilgan tizimiga O‘zbekiston Respublikasining Bosh prokurori boshchilik qiladi.\n" +
                        "Qoraqalpog‘iston Respublikasining prokurori O‘zbekiston Respublikasining Bosh prokurori bilan kelishilgan holda Qoraqalpog‘iston Respublikasining oliy vakillik organi tomonidan tayinlanadi.\n" +
                        "Viloyatlarning prokurorlari, tuman va shahar prokurorlari O‘zbekiston Respublikasining Bosh prokurori tomonidan tayinlanadi.\n" +
                        "O‘zbekiston Respublikasi Bosh prokurorining, Qoraqalpog‘iston Respublikasi prokurorining, viloyat, tuman va shahar prokurorlarining vakolat muddati — besh yil.\n" +
                        "Ayni bir shaxs surunkasiga ikki muddatdan ortiq O‘zbekiston Respublikasining Bosh prokurori lavozimini egallashi mumkin emas.")
        )

        substance25.add(Substance("145-modda","O‘zbekiston Respublikasining prokuratura organlari o‘z vakolatlarini boshqa davlat organlaridan, o‘zga tashkilotlardan, mansabdor shaxslardan mustaqil ravishda, faqat O‘zbekiston Respublikasining Konstitutsiyasiga va qonunlariga bo‘ysungan holda amalga oshiradi.\n" +
                "Prokurorlar o‘z vakolatlari davrida siyosiy partiyalarga va siyosiy maqsadlarni ko‘zlovchi boshqa jamoat birlashmalariga a’zolikni to‘xtatib turadilar.\n" +
                "Prokuratura organlarini tashkil etish, ularning vakolatlari va faoliyat ko‘rsatish tartibi qonun bilan belgilanadi."))

        substance25.add(
            Substance(
                "146-modda",
                "O‘zbekiston Respublikasi hududida jinoyatchilikka qarshi kurash bo‘yicha tezkor-qidiruv, tergov va boshqa maxsus vazifalarni mustaqil ravishda bajaruvchi xususiy tashkilotlar, jamoat birlashmalari va ularning bo‘linmalarini tuzish hamda ularning faoliyat ko‘rsatishi taqiqlanadi.\n" +
                        "Qonuniylik va huquqiy tartibotni, fuqarolarning huquqlari va erkinliklarini himoya qilishda huquqni muhofaza qiluvchi organlarga jamoat tashkilotlari va fuqarolar yordam ko‘rsatishlari mumkin.")
        )


        chap5.add(Chap("XXV bob. Prokuratura",substance25))

        val substance26=ArrayList<Substance>()

        substance26.add(Substance("147-modda","O‘zbekiston Respublikasi o‘zining yagona moliya, pul va bank tizimiga ega."))

        substance26.add(
            Substance(
                "148-modda",
                "O‘zbekiston Respublikasining Davlat budjeti respublika budjetidan, Qoraqalpog‘iston Respublikasi budjetidan va mahalliy budjetlardan iboratdir.\n" +
                        "O‘zbekiston Respublikasining Davlat budjetini shakllantirish hamda ijro etish tartib-taomillari ochiqlik va shaffoflik prinsiplari asosida amalga oshiriladi.\n" +
                        "Fuqarolar va fuqarolik jamiyati institutlari O‘zbekiston Respublikasi Davlat budjetining shakllantirilishi hamda ijro etilishi ustidan jamoatchilik nazoratini amalga oshiradi.\n" +
                        "Fuqarolarning hamda fuqarolik jamiyati institutlarining budjet jarayonida ishtirok etishi tartibi va shakllari qonun bilan belgilanadi.")
        )

        substance26.add(Substance("149-modda","O‘zbekiston Respublikasi hududida yagona soliq tizimi amal qiladi. Soliqlarni joriy qilish huquqi O‘zbekiston Respublikasining Oliy Majlisiga tegishlidir."))

        substance26.add(Substance("150-modda","O‘zbekiston Respublikasi hududida yagona soliq tizimi amal qiladi. Soliqlarni joriy qilish huquqi O‘zbekiston Respublikasining Oliy Majlisiga tegishlidir."))

        substance26.add(
            Substance(
                "151-modda",
                "O‘zbekiston Respublikasining bank tizimi O‘zbekiston Respublikasi Markaziy bankidan va banklardan iboratdir.\n" +
                        "O‘zbekiston Respublikasi Markaziy banki pul-kredit va valyuta siyosatini ishlab chiqadi hamda amalga oshiradi.\n" +
                        "O‘zbekiston Respublikasi Markaziy banki mamlakatda banklar faoliyatini tartibga solishni amalga oshiradi, bank va to‘lov tizimlarining barqaror faoliyat ko‘rsatishini ta’minlaydi.\n" +
                        "O‘zbekiston Respublikasi Markaziy banki o‘z vazifalarini bajarishda mustaqildir.\n" +
                        "O‘zbekiston Respublikasi Markaziy bankining faoliyatini tashkil etish tartibi qonun bilan belgilanad")
        )


        chap5.add(Chap("XXVI bob. Moliya, pul va bank tizimi",substance26))

        val substance27=ArrayList<Substance>()
        substance27.add(
            Substance(
                "152-modda",
                "O‘zbekiston Respublikasi Qurolli Kuchlari O‘zbekiston Respublikasining davlat suverenitetini va hududiy yaxlitligini, aholining tinch hayoti va xavfsizligini himoya qilish uchun tuziladi.\n" +
                        "Qurolli Kuchlarning tuzilishi va ularni tashkil etish qonun bilan belgilanadi.")
        )
        substance27.add(Substance("153-modda","O‘zbekiston Respublikasi o‘z xavfsizligini ta’minlash uchun yetarli darajada Qurolli Kuchlariga ega."))


        chap5.add(Chap("XXVII bob. Mudofaa va xavfsizlik",substance27))
        list.add(Department("BEShINChI BO‘LIM. DAVLAT HOKIMIYATINING TAShKIL ETILIShI",chap5))


        val chap6=ArrayList<Chap>()
        val substance28=ArrayList<Substance>()

        substance28.add(
            Substance(
                "154-modda",
                "O‘zbekiston Respublikasining Konstitutsiyasiga o‘zgartirish va qo‘shimchalar tegishincha O‘zbekiston Respublikasi Oliy Majlisining Qonunchilik palatasi deputatlari va Senati a’zolari umumiy sonining kamida uchdan ikki qismidan iborat ko‘pchiligi tomonidan qabul qilingan konstitutsiyaviy qonun yoki O‘zbekiston Respublikasining referendumi bilan kiritiladi.\n" +
                        "Ushbu Konstitutsiya 1-moddasining va ushbu modda ikkinchi qismining qoidalari qayta ko‘rib chiqilishi mumkin emas.\n" +
                        "O‘zbekiston Respublikasining Konstitutsiyasiga o‘zgartirish va qo‘shimchalar kiritish to‘g‘risidagi konstitutsiyaviy qonunda uning normalarini, shuningdek Konstitutsiyaning normalarini qo‘llashning o‘ziga xos xususiyatlari nazarda tutilishi mumkin.")
        )
        chap6.add(Chap("154-modda",substance28))

        substance28.add(Substance("155-modda","O‘zbekiston Respublikasi Oliy Majlisi tegishli taklif kiritilgandan keyin olti oy mobaynida Konstitutsiyaga o‘zgartirish va qo‘shimchalar kiritish to‘g‘risida keng va har taraflama muhokamani hisobga olgan holda konstitutsiyaviy qonun qabul qilishi mumkin. Agar O‘zbekiston Respublikasi Oliy Majlisi Konstitutsiyani o‘zgartirish to‘g‘risidagi taklifni rad etsa, taklif bir yil o‘tgandan keyingina qayta kiritilishi mumkin"))
        chap6.add(Chap("155-modda",substance28))
        list.add(Department("OLTINChI BO‘LIM. KONSTITUTSIYANI O‘ZGARTIRISh TARTIBI",chap6))



    }


}