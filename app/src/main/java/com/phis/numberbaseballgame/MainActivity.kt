package com.phis.numberbaseballgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.phis.numberbaseballgame.datas.Chat
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.numberbaseballgame_20200621.adapters.ChatAdapter

class MainActivity : BaseActivity() {

    val chatList = ArrayList<Chat>()
    lateinit var mChatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        chatList.add(Chat("CPU", "숫자 야구게임에 오신 것을 환영합니다."))
        chatList.add(Chat("CPU", "세 자리 숫자를 맞춰주세요."))
        chatList.add(Chat("CPU", "0은 포함되지 않으며, 중복된 숫자도 없습니다."))

        mChatAdapter = ChatAdapter(mContext, R.layout.chat_list_item, chatList)
        chatListView.adapter = mChatAdapter

    }


}