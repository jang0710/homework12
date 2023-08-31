package com.example.applemarket

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applemarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNotification.setOnClickListener {
            notification()
        }

        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.sample1, "산지 한달된 선풍기 팝니다.","이사가서 필요가 없어졌어요. 급하게 내놓습니다.","대현동","서울 서대문구 창천동", "1,000원",25,13))
        dataList.add(MyItem(R.drawable.sample2, "김치냉장고","이사로 인해 내놔요.","안마담","인천 계양구 귤현동", "20,000원",28,8))
        dataList.add(MyItem(R.drawable.sample3, "샤넬 카드지갑","고퀄지갑이구요.\n사용감이 있어서 싸게 내어둡니다.","코코유","수성구 범어동", "10,000원",5,23))
        dataList.add(MyItem(R.drawable.sample4, "금고","금고떼서 가져가야함\n대우월드마크센텀\n미국이주관계로 싸게 팝니다.","Nicole","해운대구 우제2동", "10,000원",17,14))
        dataList.add(MyItem(R.drawable.sample5, "갤럭시Z플립3 팝니다.","갤럭시 Z플립3 그린 팝니다.\n항시 케이스 씌워서 썻고 필름 한장챙겨드립니다.\n화면에 살짝 스크래치난거 말고 크게 이상은없습니다!","절명","연제구 연산제8동", "150,000원",9,22))
        dataList.add(MyItem(R.drawable.sample6, "프라다 복조리백","까임 오염 없고 상태 깨끗합니다.\n정품 여부 모름","미니멀하게","수원시 영통구 원천동", "50,000원",16,25))
        dataList.add(MyItem(R.drawable.sample7, "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장","울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다.)\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\n2. 장소: 북구 블루마시티, 32-33층\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\n6. 고기 굽기 가능\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\n8. 층간소음 주의 부탁드립니다.\n9. 방3개, 화장실3개, 비데 3개\n10. 저희 집안이 쓰는 별장입니다.","굿리치","남구 옥동", "150,000원",54,142))
        dataList.add(MyItem(R.drawable.sample8, "샤넬 탑핸들 가방","샤넬 트랜디 CC 탑핸들 스몰 램스킨 블랙 금장 플랩백 !\n + 색상 : 블랙\n + 사이즈 : 25.5cm * 17.5cm * 8cm\n + 구성 : 본품더스트\n + 급하게 돈이 필요해서 팝니다 ㅠ ㅠ","난쉽","동래구 온천제2동", "180,000원",7,31))
        dataList.add(MyItem(R.drawable.sample9, "4행정 엔진분무기 판매합니다.","3년전에 사서 한번 사용하고 그대로 둔 상태입니다. 요즘 사용은 안해봤습니다. 그래서 저렴하게 내 놓습니다. 중고라 반품은 어렵습니다.\n","알뜰한","원주시 명륜2동", "30,000원",28,7))
        dataList.add(MyItem(R.drawable.sample10, "셀린느 버킷 가방","22년 신세계 대전 구매입니당\n + \"셀린느 버킷백\n + \"구매해서 몇번사용했어요\n + \"까짐 스크래치 없습니다.\n + \"타지역에서 보내는거라 택배로 진행합니당!\"","똑태현","중구 동화동", "190,000원",6,40))

        val adapter = AppleAdapter(dataList)
        binding.recyclerView.adapter = AppleAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : AppleAdapter.ItemClick {
            override fun onClick(view: View, position: Int, item: MyItem) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("selected_item", item)
                startActivity(intent)

            }
        }
    }
    override fun onBackPressed() {   // 뒤로가기 누르면 다이얼로그 생성
        val builder = AlertDialog.Builder(this)
        builder.setTitle("종료") // 다이얼로그 제목
        builder.setMessage("정말로 종료하시겠습니까?") // 다이얼로그 내용
        builder.setIcon(R.drawable.bubble) // 타이틀 옆 이미지
        builder.setCancelable(false) // 다이얼로그 화면 밖 터치 방지
        builder.setPositiveButton("확인") { _, _ ->
            finish() // 앱 종료 처리
        }
        builder.setNegativeButton("취소") { dialog, _ ->
            dialog.dismiss() // 다이얼로그 닫기
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }
    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder
        // 여기서 부터 채널 정보 설정 (26버전 이상)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                // 채널의 정보, 기능을 추가하는 곳
                description = "My Channel One Description"
                setShowBadge(true)
                // 여기서 부터 오디오 코드
//                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
//                val audioAttributes = AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                    .setUsage(AudioAttributes.USAGE_ALARM)
//                    .build()
//                setSound(uri, audioAttributes)
//                enableVibration(true) // 오디오코드 끝
            }
            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel) //채널 넣기
            // 채널을 이용하여 builder 생성
            builder = NotificationCompat.Builder(this, channelId) // 아이디 넣기
        } else {
            // 26버전 이하
            builder = NotificationCompat.Builder(this)
        }
        val largeBitmap = BitmapFactory.decodeResource(resources, R.drawable.sample10) // 알림에 출력할 사진
        val intent = Intent(this, MainActivity::class.java) // 알림을 누르면 앱으로 들어가게 해준다.
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        // 알림의 기본정보
        builder.run {
            setSmallIcon(R.drawable.account) // 알림에 출력되는 아이콘
            setWhen(System.currentTimeMillis()) // 알림의 발생 시간 에뮬레이터의 시간으로 설정
            setContentTitle("애플 마켓")
            setContentText("오늘의 추천 물품!")
            // 큰 이미지 설정
            setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(largeBitmap) // 사진의 크기를 키운다.
                    .bigLargeIcon(null))
            // 긴 텍스트 설정
            setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("22년 신세계 대전 구매입니당.\n셀린느 버킷백\n구매해서 몇번사용했어요.\n까짐 스크래치 없습니다.\n타지역에서 보내는거라 택배로 진행합니당!"))
            setLargeIcon(largeBitmap) // 사진이 출력되는 공간
            addAction(R.mipmap.ic_launcher, "확인", pendingIntent)
        }
        manager.notify(11,builder.build()) // 빨간줄이 뜬다면 POST_NOTIFICATIONS 권한이 없어서이다. 느낌표를 눌러서 추가하도록 하자.
    }
}