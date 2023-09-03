package com.example.newsreader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsreader.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTitleBinding.inflate(inflater, container, false)
        val view = binding.root

        // RecyclerView 설정 및 어댑터 연결
        val newsList = mutableListOf<NewsItem>()
            newsList.add(
                NewsItem(
                    R.drawable.fire_accident,
                    "부산 목욕탕 화재 진압 중 폭발…구청장·소방관 등 17명 중경상",
                    "초동 진화 잔불 정리 과정 2차 폭발…시민 포함 다수 폭발 잔해에 다쳐",
                    "차근호 김선호 기자 = 부산 한 목욕탕에서 불이 난 뒤 원인이 밝혀지지 않은 폭발이 발생하면서 구청장과 소방관 등 10여 명이 다쳤다.\n" +
                            "\n" +
                            " 1일 오후 1시 40분께 부산 동구 좌천동의 한 목욕탕에서 불이 났다. 진화에 나선 소방대원이 큰 불길을 잡았다.\n" +
                            "\n" +
                            " 이 목욕탕은 이날 영업을 하지 않아 손님 피해는 없었다.\n" +
                            "\n" +
                            " 하지만 갑작스러운 2차 폭발로 잔불을 정리 중이던 소방대원과 화재 현장 부근에 나온 공무원, 시민 등 다수가 폭발 잔해에 다쳤다.\n" +
                            "\n" +
                            " 부산소방본부에 따르면 부상자는 중상자 2명을 포함해 모두 17명으로 파악됐다.\n" +
                            "\n" +
                            " 이 사고로 현장을 점검하러 온 김진홍 부산 동구청장도 다쳐 병원 응급실에서 치료받는 것으로 알려졌다.",
                    "2023-09-01 15:49"
                )
            )
            newsList.add(
                NewsItem(
                    R.drawable.son,
                    "최전방 올라가자마자 해트트릭 폭발…돌아온 '번리 킬러' 손흥민",
                    "히샤를리송 부진에 포스테코글루 감독 '손톱' 결단…한 경기만에 적중",
                    "(서울=연합뉴스) 최송아 기자 = 잉글랜드 프로축구 프리미어리그(EPL) 토트넘과 한국 국가대표팀의 '캡틴' 손흥민이 소속팀에서 최전방 이동 효과를 톡톡히 누리며 시즌 첫 득점포에 해트트릭까지 폭발했다.\n" +
                            "\n" +
                            "손흥민은 2일(현지시간) 영국 잉글랜드 번리의 터프 무어에서 열린 번리와의 2023-2024 EPL 4라운드 원정 경기에서 전반 16분 1-1 균형을 맞추는 골을 터뜨리며 시즌 마수걸이 골을 신고했다.\n" +
                            "\n" +
                            "이어 후반 18분과 21분에도 연속 득점포를 가동하며 팀의 5-2 완승에 앞장섰다.\n" +
                            "\n" +
                            "지난 시즌에도 레스터시티를 상대로 해트트릭으로 시즌 1∼3호 골을 몰아 넣었던 손흥민은 약 1년 만에 해트트릭을 작성, EPL에서 개인 통산 4번째 해트트릭의 기쁨을 누렸다.\n" +
                            "\n" +
                            "'단짝' 해리 케인이 독일 분데스리가 바이에른 뮌헨으로 이적하며 토트넘의 주장을 맡게 된 이번 시즌 손흥민은 앞선 리그 3경기, 리그컵(카라바오컵) 1경기에선 공격 포인트 침묵을 이어왔다.\n" +
                            "\n" +
                            "하지만 최전방 원톱으로 기용되자마자 골 감각을 제대로 발휘하며 팀의 해결사로 우뚝 섰다.\n" +
                            "\n" +
                            "이번 시즌 토트넘 지휘봉을 잡은 뒤 케인의 이적이라는 큰 변수와 맞닥뜨린 엔지 포스테코글루 감독은 처음엔 브라질 국가대표 공격수 히샤를리송에게 최전방을 맡겼다.",
                    "2023-09-03 02:08"
                )
            )
            newsList.add(
                NewsItem(
                    R.drawable.gunshan,
                    "군산 초등 교사 '눈물의 발인'…동료 교사들도 마지막 길 배웅",
                    "영정 뒤따르며 하염없이 눈물, \"가정적인 남편, 아빠였는데…\"\n" +
                            "\"전화할 때마다 학교, 힘들다고 말해\"…유족 \"추후 입장 정리\"",
                    "\n" +
                            "(군산=연합뉴스) 임채두 기자 = 전북 군산시 동백대교 아래서 쓸쓸한 죽음을 맞은 초등학교 교사의 발인식이 3일 은파장례문화원에서 엄수됐다.\n" +
                            "\n" +
                            "장례식장에 모인 A 교사의 가족과 친지, 동료 교사들은 고인의 영정 앞에 술잔을 올리고 생전의 그를 떠올렸다.\n" +
                            "\n" +
                            "가족들은 젊디젊은 나이에 세상을 등진 A 교사를 추모하며 미처 못다 한 말 한마디씩을 나지막이 건넸다.\n" +
                            "\n" +
                            "동료 교사들은 가족과 친지 뒤에서 두 손으로 얼굴을 감싸고 눈물을 연신 닦아냈다.\n" +
                            "\n" +
                            "운구차로 옮겨지는 관을 조용히 뒤따르면서도 마른 줄 알았던 눈물이 하염없이 쏟아냈다.\n" +
                            "\n" +
                            "운구차 앞에 선 이들은 고인 영정 앞에 고개를 숙였다가 야속하리만치 화창한 하늘을 올려다보며 벅차오르는 감정을 겨우 추슬렀다.\n" +
                            "\n" +
                            "한 유족은 고인의 이름을 부르고 흐느끼기를 반복하다 의자에 몸을 맡겼다.\n" +
                            "\n" +
                            "A 교사와 둘도 없이 친했던 동료 교사는 고인을 가정적인 남편, 아빠로 기억했다.\n" +
                            "\n" +
                            "그는 \"자녀를 너무 사랑하고 아내를 아끼던 가정적인 형이었다\"며 \"늘 열정적인 사람이었는데 갑자기 이런 일이…\"라며 말을 제대로 잇지 못했다.\n" +
                            "\n" +
                            "그러면서 \"전화할 때마다 학교에서 일을 하고 있었다\"며 \"형이 힘들다고 말할 때 직접 만나서 위로해주지 못한 게 너무 한이 된다\"고 울음을 터뜨렸다.\n" +
                            "\n" +
                            "이내 감정을 추스른 이 교사는 \"형은 올해 들어 쉽게 잠에 들지 못해 더 힘들어했다\"며 \"업무와 관련해 특정 교원과 어려움을 표현하기도 했다\"고 말했다.\n" +
                            "\n" +
                            "화장장에 도착한 유족들은 영정과 관을 들고 안으로 들어갔다.\n" +
                            "\n" +
                            "고인의 마지막 길을 지킨 이들은 뺨을 타고 흐르는 눈물을 닦느라 손이 바빴다.\n" +
                            "\n" +
                            "정재석 전북교사노동조합 위원장은 \"고인의 사인을 업무 과다로 인한 스트레스로 보고 있다\"며 \"고인과 함께 근무했던 교원들은 A 교사의 죽음에 조속히 답을 해야 할 것\"이라고 말했다.\n" +
                            "\n" +
                            "유족들은 이와 관련해 \"나중에 입장을 정리하겠다\"는 말을 아꼈다.\n" +
                            "\n" +
                            "A 교사가 군산 동백대교 아래 해상에서 숨진 채 발견된 때는 지난 1일 오전 10시 25분이다.\n" +
                            "\n" +
                            "군산해양경찰서는 수중 수색 26시간여 만에 A 교사의 시신을 인양했다.\n" +
                            "\n" +
                            "동백대교 인근에 주차된 A 교사의 승용차 안에서는 휴대전화가 발견됐으며 휴대전화 배경 화면에 유서 형태의 메모가 발견됐다.\n" +
                            "\n" +
                            "유서는 A 교사가 자신을 자책하면서 가족에게 작별 인사를 전하는 내용인 것으로 알려졌다.\n" +
                            "\n" +
                            "경찰은 국립과학수사연구원에 휴대전화 포렌식을 맡겨 A 교사가 남겨놓은 추가 메시지를 확인할 예정이다.",
                    "2023-09-03 11:36"
                )
            )
            newsList.add(
                NewsItem(
                    R.drawable.missile,
                    "북 \"어제 장거리전략순항미사일 발사는 전술핵공격 가상발사훈련\"",
                    "한미 연합공중훈련 반발…\"실질적 핵위기 경고\"",
                    "(서울=연합뉴스) 김지연 기자 = 북한은 지난 2일 새벽 장거리 전략순항미사일을 발사하며 전술핵공격 가상발사훈련을 진행했다고 3일 밝혔다.\n" +
                            "\n" +
                            "조선중앙통신은 이날 \"조선노동당 중앙군사위원회는 적들의 침략전쟁 기도를 억제할 수 있는 행동 의지와 능력을 철저히 시위한 데 대한 해당 군사훈련 명령을 하달했다\"며 전날 새벽 \"적들에게 실질적인 핵위기에 대해 경고하기 위한 전술핵 공격 가상 발사훈련\"이 진행됐다고 보도했다.\n" +
                            "\n" +
                            "조선인민군 서부지구 전략순항미사일운용부대가 해당 군사활동을 진행했다.\n" +
                            "\n" +
                            "통신은 \"발사에 앞서 핵공격명령 인증절차와 발사 승인체계의 기술적 및 제도적 장치들의 신속한 가동 정상성을 검열하고 신속한 승인절차에 따라 핵전투부를 모의한 시험용전투부를 장착한 장거리 전략순항미싸일(미사일) 2기가 실전 환경 속에서 발사됐다\"고 전했다.\n" +
                            "\n" +
                            "이어 \"훈련에 동원된 미싸일병구분대는 청천강하구에서 장거리전략순항미싸일들을 조선서해로 발사하여 1,500㎞계선의 거리를 모의한《8》자형비행궤도를 각각 7천672∼7천681s(초)간 비행시킨 후 목표섬상공의 설정고도 150m에서 공중폭발시켜 핵타격임무를 정확히 수행했다\"고 주장했다.\n" +
                            "\n" +
                            "통신은 지난달 31일 한미연합연습 '을지 자유의 방패(UFS)' 종료 이후 곧바로 이틀간 실시된 한미 공대공 및 공대지 무장 실사격 훈련에 대해 \"군사적 대결기도를 더욱 노골적으로 드러내보였다\"며 \"미국과 《대한민국》깡패들이 최근에 드러내보인 대결광기의 무모성과 위험성은 사상 그 유례를 찾아볼 수 없다\"고 주장했다.\n" +
                            "\n" +
                            "합동참모본부는 전날 오전 4시께부터 북한이 서해상으로 발사한 순항미사일 수 발을 포착했다고 밝힌 바 있다.",
                    "2023-09-03 07:08"
                )
            )
            newsList.add(
                NewsItem(
                    R.drawable.national_pension,
                    "국민연금 가입자 올해부터 본격 감소할까…\"1년새 7만명↓\"",
                    "5월 기준 국민연금 공표통계 분석…수급자는 43만명 증가",
                    "(서울=연합뉴스) 고미혜 기자 = 저출산·고령화에 대비하기 위한 국민연금 개혁 논의가 한창인 가운데 국민연금 가입자가 올해부터 본격적인 감소 추세에 들어설지 주목된다.\n" +
                            "\n" +
                            "3일 국민연금공단의 최신 통계인 '2023년 5월 기준 국민연금 공표통계'에 따르면 5월 말 기준 국민연금 가입자는 모두 2천225만4천964명이다.\n" +
                            "\n" +
                            "1년 전인 지난해 5월 말 가입자(2천232만7천648명)보다 7만2천여 명 적은 것이어서 올해 연말 기준으로도 작년 말보다 줄어들 가능성이 있다.\n" +
                            "\n" +
                            "국민연금 가입자가 전년도보다 줄어든 일은 이전에도 몇 차례 있었다.\n" +
                            "\n" +
                            "국민연금 가입자는 도입 첫해인 1988년 말 443만 명에서 30여 년 만에 약 5배로 꾸준히 늘었지만 1998년, 2000년, 2004년, 2017년 일시적인 감소세를 보였다.\n" +
                            "\n" +
                            "2019년과 2020년에는 코로나19 인한 지역가입자 감소 등이 겹치며 2년 연속 감소세를 이어가기도 했다.\n" +
                            "\n" +
                            "그러나 다시 증가세를 회복하며 2021년 말 2천234만8천 명, 작년 말 2천249만8천 명으로 최고치를 고쳐썼다.\n",
                    "2023-09-03 08:39"
                )
            )
            newsList.add(
                NewsItem(
                    R.drawable.lh,
                    "소송도 몰아주기…LH 소송 수임 상위 변호사 모두 '전관'",
                    "전관 변호사 2명, 5년여간 소송 630건 수임…약 32억원 받아가\n" +
                            "법률 자문도 전관 변호사가 대거 맡아…LH \"업무 관련 전문성 고려\"",
                    "(서울=연합뉴스) 박초롱 김치연 기자 = 한국토지주택공사(LH)가 설계·감리뿐 아니라 소송도 대거 전관에게 맡긴 것으로 나타났다.\n" +
                            "\n" +
                            "LH는 공공택지 조성, 임대주택 공급 등 업무 특성상 소송이 많다. LH가 이런 소송을 다수 위임한 변호사는 모두 LH 근무 경력이 있는 전관이었다.\n" +
                            "\n" +
                            "3일 국회 국토교통위원회 소속 더불어민주당 박상혁 의원이 LH에서 제출받은 '소송위임 현황' 자료에 따르면 2018년부터 최근까지 5년여간 LH가 소송을 가장 많이 위임한 소송대리인은 A 변호사로, 모두 375건을 맡았다.\n" +
                            "\n" +
                            "LH는 A 변호사에게 수임료로 16억9천만원을 지급했다. 한 건당 450만원꼴이다. A 변호사는 8년간 LH에 근무하다가 변호사 자격을 취득한 '전관'이다.\n" +
                            "\n" +
                            "두 번째로 수임 건수가 많은 B 변호사는 LH 소송 255건을 대리했고, 수임료로 15억원을 받았다. B 변호사는 변호사 시험에 합격한 뒤 LH 법무실에서 일한 경력이 있다.\n" +
                            "\n" +
                            "A 변호사와 B 변호사가 받은 수임료 규모는 LH 소송을 담당한 법무법인·개인 변호사 중에서 상위 1·2위다.\n" +
                            "\n" +
                            "법무법인과 법률사무소를 제외한 개인 변호사 기준으로 A·B 변호사 다음으로는 3년여간 LH에서 일한 경력이 있는 C 변호사가 LH 소송을 많이 맡았다. 소송 110건을 맡아 수임료로 7억원을 받았다.\n" +
                            "\n" +
                            "개인 변호사 소송대리 상위 4위인 D 변호사는 148건을 맡아 수임료로 6억9천만원을 받았다. D 변호사 역시 3년여간 LH에서 일하다가 변호사 자격증을 취득했다. 이후 3년간 LH 사내 변호사로 일하기도 했다.\n" +
                            "\n" +
                            "LH 출신 변호사들은 모두 퇴사 이후 LH 법률고문을 장기간 맡았거나, 맡고 있다는 공통점이 있다. 법률고문으로서 사건을 대량으로 수임하는 구조다.\n" +
                            "\n" +
                            "전관 출신 변호사는 LH 업무 내용과 관련 분야를 잘 파악하고 있기에 전문성이 뛰어나 소송을 많이 맡는 것으로 볼 수도 있다.\n" +
                            "\n" +
                            "그러나 LH 소송을 다수 대리한 상위 변호사가 모두 전관이라는 것은 주목할 만한 지점이다.\n" +
                            "\n" +
                            "LH는 소송뿐 아니라 자문도 전관 변호사에게 다수 몰아줬다. LH 소송대리 건수가 많은 변호사가 자문도 대거 맡은 것으로 나타났다.\n" +
                            "\n" +
                            "2018년부터 최근까지 LH 법률 자문 상위 20위 현황을 보면, 전체 자문 564건 중 133건을 LH 근무 경험이 있는 변호사 4명이 나눠 맡았다.\n" +
                            "\n" +
                            "LH 소송대리를 두 번째로 많이 한 B 변호사는 총 70건의 자문을 맡아 자문료로 4천20만원을 받았다.\n" +
                            "\n" +
                            "개인 변호사 기준으로 B 변호사에 이어 가장 많은 자문을 맡은 C 변호사는 27건을 자문해 1천405만원을 받았다.\n" +
                            "\n" +
                            "LH 소송대리를 가장 많이 한 A 변호사는 13건을 자문했다.\n" +
                            "\n" +
                            "이 밖에 LH에서 6년간 일한 E 변호사는 23건을 자문해 1천135만원을 받았다.\n" +
                            "\n" +
                            "LH 내부 사정을 잘 아는 한 법조인은 \"LH 지역본부에서 개별적으로 발주되는 단순 사건도 많은데, 이런 업무 역시 내부적으로 관계가 있는 변호사나 LH 출신 변호사가 다수 수임하는 것으로 안다\"고 말했다.\n" +
                            "\n" +
                            "그는 \"서로 밀어주고 끌어주는 과정에서 LH가 소송 비용을 절감하려는 노력을 하지 않고 수임료를 지급하는 것 아니냐\"고 주장했다.\n" +
                            "\n" +
                            "LH 관계자는 이와 관련해 \"내부 규정과 LH 업무와 관련한 전문성, 능력을 고려해 소송을 맡기고 있다\"며 \"자문은 통상 자문료에 비해 단가가 낮기 때문에 맡기 꺼리는 경우가 많아 자문해 줄 변호사를 찾기 어려운 것이 현실\"이라고 설명했다.",
                    "2023-09-03 06:31"
                )
            )
            newsList.add(
                NewsItem(
                    R.drawable.russia,
                    "\"러시아-크림반도 잇는 크림대교 통행 한때 차단\"(종합)",
                    "러시아 본토와 크림반도를 잇는 주요 교량의 통행이 한때 차단됐다고 3일(현지시간) 로이터통신이 보도했다.",
                    "(서울=연합뉴스) 최재서 기자 = 보도에 따르면 러시아의 지역 행정 당국은 이날 오전 텔레그램 채널을 통해 크림대교 통행을 일시적으로 중단했다가 재개했다고 밝혔다.\n" +
                            "\n" +
                            "통행을 차단한 이유는 언급하지 않았다.\n" +
                            "\n" +
                            "크림반도는 러시아가 2014년 강제 병합한 지역으로, 크림대교는 최근 수개월 사이 우크라이나의 집중 공격 대상이 됐다.\n" +
                            "\n" +
                            "앞서 러시아는 1~2일 크림대교를 공격하려던 우크라이나 드론 보트 3대를 파괴했다고 밝히기도 했다. 이때도 크림대교 통행이 임시 중단됐다.\n" +
                            "\n" +
                            "러시아는 크림대교 주변에 선박 여러 척을 침몰시켜 드론 보트의 접근을 막는 등 주변 경계를 강화하고 있다.",
                    "2023-09-03 11:04"
                )
            )
            newsList.add(
                NewsItem(
                    R.drawable.thanksgiving,
                    "추석 성수품 가격은?…1년 전보다 과일은 비싸고 채소는 저렴",
                    "작년 대비 사과 61%↑·배 27%↑…배추 51%↓·무 30%↓\n" +
                            "닭고기 도매가는 24.9%↑…정부, 추석 성수품 공급량 확대",
                    "(서울=연합뉴스) 신선미 기자 = 추석 성수기 수요가 증가하는 사과, 배 등 과일 가격은 1년 전보다 높은 반면, 배추, 무 등 채소류 가격은 상대적으로 낮은 수준을 유지하는 것으로 나타났다.\n" +
                            "\n" +
                            "3일 한국농수산식품유통공사(aT) 농산물유통정보, 축산물품질평가원 축산유통정보 등에 따르면 지난 1일 기준 사과(홍로·상품) 도매가격은 10kg에 8만5천660원으로 1년 전 5만3천252원보다 60.9% 상승했다.\n" +
                            "\n" +
                            "2018∼2022년 가격 중 최대·최소치를 제외한 3년 평균인 평년 가격(5만1천580원)과 비교하면 66.1% 높다.\n" +
                            "\n" +
                            "배(원황·상품) 도매가격은 15kg에 5만6천920원으로 1년 전 4만4천864원과 비교해 26.9% 비싸고, 평년 가격(4만7천573원)보다는 19.6% 상승했다.\n" +
                            "\n" +
                            "올해 사과, 배 가격 상승은 날씨 영향에 작황이 좋지 않아 공급량이 감소한 것이 주요 원인으로 꼽힌다.\n" +
                            "\n" +
                            "농림축산식품부는 추석 성수기 주요 농축산물의 가격 안정을 위해 정부 비축, 농협 계약재배 물량 등을 시장에 추가로 공급하는데, 올해는 사과, 배 공급량을 작년 추석 성수기보다 각각 7.1%, 8.3% 확대하기로 했다.\n" +
                            "\n" +
                            "추석 성수품 중 채소류 가격을 보면 배추는 10kg에 1만4천440원으로 1년 전 2만9천456원보다 51.0% 낮고, 평년의 1만8천214원보다 20.7% 하락했다.\n" +
                            "\n" +
                            "무 도매가격은 20kg에 2만1천20원으로 1년 전(2만9천904원)보다 29.7% 감소했고, 평년(2만1천909원)보다 4.1% 하락했다.\n" +
                            "\n" +
                            "농식품부 관계자는 \"배추, 무 수급은 현재 안정적이지만 기상 악화에 따라 상황이 바뀔 수 있는 만큼 미리 비축한 물량과 계약재배 물량 등을 활용해 수급 불안시 신속히 대응할 계획\"이라고 말했다.\n" +
                            "\n" +
                            "이 밖에 양파(15kg 기준 2만1천140원)와 마늘(깐마늘 20kg 기준 13만167원) 도매가격은 1년 전과 비교해 각각 6.4%, 21.9% 떨어졌다.\n" +
                            "\n" +
                            "평년과 비교하면 지난 1일 양파 도매가격은 52.4% 비싸지만, 마늘 가격은 2.1% 하락했다.\n" +
                            "\n" +
                            "축산물 중에서는 공급량 감소에 따라 닭고기 가격이 1년 전보다 비싼 수준이다.\n" +
                            "\n" +
                            "1일 기준 닭고기 1kg당 도매가격은 3천680원으로, 1년 전 2천947원과 비교해 24.9% 올랐다.",
                    "2023-09-03 07:00"
                )
            )
            newsList.add(
                NewsItem(
                    R.drawable.seshu,
                    "'세수펑크 대책' 퍼즐맞춘 정부…키워드는 '외평기금→공자기금'(종합)",
                    "'외환 방파제' 외평기금·'공공기금 저수지' 공자기금, 구원투수 역할",
                    "(세종=연합뉴스) 이준서 박원희 기자 = 유례없는 '세수펑크 사태'에 대응할 주요 재원으로 꼽히는 기금(基金)은 일반회계·특별회계와는 달리 특정한 목적을 위해 운용되는 특정 자금을 말한다.\n" +
                            "\n" +
                            "통상 세수결손 재원으로는 활용되지 않지만, 이례적으로 상당액의 기금 여유재원이 생기면서 구원투수로 적극 검토되고 있는 상황이다.\n" +
                            "\n" +
                            "3일 관계 부처에 따르면 기획재정부가 주목하는 카드는 외국환평형기금(외평기금)과 공공자금관리기금(공자기금)이다.\n" +
                            "\n" +
                            "\n" +
                            "다소 복잡하지만, 외평기금의 원화 여유재원을 공자기금으로 넘기면 이를 일반회계에 투입하는 방식이다. 일정 비율까지는 행정부 재량으로 공자기금 자금의 일반회계 전환이 가능하다.\n" +
                            "\n" +
                            "빚을 내지 않고 세수 부족을 메우겠다고 강조한 추경호 부총리 겸 기획재정부 장관의 '숨겨둔 카드'인 셈이다.\n" +
                            "\n" +
                            "우선 외평기금은 급격한 환율 변동에 대응하기 위한 기금이다.\n" +
                            "\n" +
                            "투기적 수요로 환율이 급등락하게 되면, 보유하고 있는 달러화 또는 원화를 활용해 시장의 환율을 안정시키는 '외환 방파제' 역할을 한다.\n" +
                            "\n" +
                            "지난해부터 고공 행진한 원·달러 환율을 안정시키기 위해 외환당국은 달러를 팔고 원화를 사들여왔고, 이에 따라 외평기금에 원화가 이례적으로 대규모로 쌓인 것으로 알려졌다.\n" +
                            "\n" +
                            "이 때문에 환율이 비교적 안정적으로 유지되는 상황에서 원화 예수금을 '재정 실탄'으로 활용할 여유가 있긴 것으로 알려졌다. 환율이 급격한 하락세를 보이지 않는다면 당분간 외평기금의 원화 자금을 시장에 투입할 가능성도 작다는 판단이 깔린 것으로 보인다.\n" +
                            "\n" +
                            "결과적으로 외평기금에서 최소 10조원, 최대 20조원의 '실탄' 확보가 가능하지 않겠느냐는 분석이 나온다.",
                    "2023-09-03 10:53"
                )
            )
        val adapter = NewsAdapter(newsList)
        binding.titleRecyclerView.adapter = adapter
        binding.titleRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // RecyclerView 아이템 클릭 처리
        adapter.itemClick = object : NewsAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                (requireActivity() as MainActivity).showDetailFragment()
            }
        }
        return view
    }
}