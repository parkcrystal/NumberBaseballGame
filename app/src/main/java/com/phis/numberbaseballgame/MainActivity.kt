package com.phis.numberbaseballgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.phis.numberbaseballgame.datas.Chat
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.numberbaseballgame_20200621.adapters.ChatAdapter

class MainActivity : BaseActivity() {

//    문제로 나온 숫자를 담는 배열
    val cpuNumList = ArrayList<Int>()

    val chatList = ArrayList<Chat>()
    lateinit var mChatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        inputBtn.setOnClickListener {

//            사용자 입력값을 받아오자
            val inputNum = numberEdt.text.toString()

//            세자리일떄때만 OK
            if (inputNum.length != 3) {

                Toast.makeText(mContext, "세자리 숫자만 입력 가능합니다.", Toast.LENGTH_SHORT).show()
//                이벤트 강제 종료
                return@setOnClickListener

            }

//            입력값이 3자리임이 보증됨.
//            사용자가 한 말로 입력 처리 => 채팅 내역으로 추가
            chatList.add(Chat("ME", inputNum))

            mChatAdapter.notifyDataSetChanged()

//            한번 숫자 입력시 입력칸 비워주기
            numberEdt.setText("")

        }

    }

    override fun setValues() {

//        정답이 될 문제를 미리 만들어두자
        makeQuestionNum()

        chatList.add(Chat("CPU", "숫자 야구게임에 오신 것을 환영합니다."))
        chatList.add(Chat("CPU", "세 자리 숫자를 맞춰주세요."))
        chatList.add(Chat("CPU", "0은 포함되지 않으며, 중복된 숫자도 없습니다."))

        mChatAdapter = ChatAdapter(mContext, R.layout.chat_list_item, chatList)
        chatListView.adapter = mChatAdapter

    }

    fun makeQuestionNum() {

//        세자리 숫자를 만든다 => 한자리씩 배열에 저장. Ex)741 => 7, 4, 1

        for (i in 0..2) {
//            조건에 맞는 숫자가 나오면 배열에 대입.
//            조건에 안맞는 숫자가 나오면 다시 뽑자.
//            조건에 맞는 숫자가 뽑힐 때까지 계속 뽑자.

            while (true) {

//              1 <=  (Math.random()*9+1).toInt() < 10
//              우리가 원하는 숫자 : 0 제외. 1~9 정수
                val randomNum = (Math.random()*9+1).toInt()

//                중복된 숫자면 안됨. => 문제 배열을 보고 같은 숫자가 있는지?
//                있다면 사용 불가 (중복)

//                일단 써도 된다고 했다가 => 검사결과 같은게 있다면 => 쓰면 안된다고.
                var duplCheckResult = true

                for (num in cpuNumList) {
                    if (num == randomNum) {
//                        문제에 같은 숫자가 있다1 => 사용하면 안된다!
                        duplCheckResult = false
                    }
                }

//                1~9사이의 랜덤숫자가 중복검사를 통과 했는지?
                if (duplCheckResult) {
//                    써도 되는 숫자이니까 출제 숫자에 등록.
                    cpuNumList.add(randomNum)
//                    무한반복을 깨고 다음숫자를 뽑으러 이동.
                    break
                }
            }

        }


    }

}