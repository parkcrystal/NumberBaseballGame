package kr.co.tjoeun.numberbaseballgame_20200621.adapters

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.phis.numberbaseballgame.R
import com.phis.numberbaseballgame.datas.Chat

import org.json.JSONObject

class ChatAdapter(
    val mContext:Context,
    val resId:Int,
    val mList:List<Chat>) : ArrayAdapter<Chat>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.chat_list_item, null)
        }

        val row = tempRow!!

        val computerLayout = row.findViewById<LinearLayout>(R.id.computerLayout)
        val computerTxt = row.findViewById<TextView>(R.id.computerLayout)
        val myLayout = row.findViewById<LinearLayout>(R.id.myLayout)
        val myTxt = row.findViewById<TextView>(R.id.myLayout)

        val data = mList[position]

//        컴퓨터가 말하면? 왼쪽 배치 레이아웃 보여주고, 오른쪽 배치 레이아웃 숨기기.
//        그 외에는? 왼쪽 배치 숨기고, 오른쪽 배치 보여주기.
        if (data.who == "CPU") {
            computerLayout.visibility = View.VISIBLE     //보이기
            myLayout.visibility = View.GONE              //숨기기

//            컴퓨터가 말한 내용이니 컴퓨터 텍스트뷰에 적용.
            computerTxt.text = data.content
        }
        else {
            computerLayout.visibility = View.GONE        //숨기기
            myLayout.visibility = View.VISIBLE           //보이기
            
//            내가 말한 내용이니 내 텍스트뷰에 적용.
            myTxt.text = data.content
        }

        return row
    }
}
