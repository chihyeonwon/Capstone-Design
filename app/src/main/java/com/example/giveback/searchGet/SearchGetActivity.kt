package com.example.giveback.searchGet

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.giveback.R
import com.example.giveback.databinding.ActivitySearchGetBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class SearchGetActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySearchGetBinding

    private lateinit var category: String

    private lateinit var selectedStartDay: Calendar // 선택된 시작일을 담아줄 변수
    private lateinit var selectedEndDay: Calendar // 선택된 종료일을 담아줄 변수

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_get)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_search_get)

        // 기본 날짜를 오늘 날짜로 지정
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        calendar.set(year, month, day)

        // 시작일을 오늘 날짜로 initialized.
        selectedStartDay = Calendar.getInstance().apply {
            set(year, month, day)
        }
        // 종료일을 오늘 날짜로 initialized.
        selectedEndDay = Calendar.getInstance().apply {
            set(year, month, day)
        }

        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일")

        // 기본 시작일과 종료일을 오늘 날짜로 지정
        binding.getStartDate.text = dateFormat.format(calendar.time).toString()
        binding.getEndDate.text = dateFormat.format(calendar.time).toString()

        // 카테고리를 선택해주세요 버튼을 눌렀을 때 카테고리 설정 창으로 이동한다.
        binding.getCategoryArea.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.category_item, null)
            val mBuilder = android.app.AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("카테고리 설정창")

            val alertDialog = mBuilder.show()

            // 지갑을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.wallet)?.setOnClickListener {
                Toast.makeText(this, "지갑 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.wallet).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 카드을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.card)?.setOnClickListener {
                Toast.makeText(this, "카드 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.card).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 현금을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.cash)?.setOnClickListener {
                Toast.makeText(this, "현금 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.cash).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 가방을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.bag)?.setOnClickListener {
                Toast.makeText(this, "가방 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.bag).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 전자기기을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.device)?.setOnClickListener {
                Toast.makeText(this, "전자기기 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.device).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 의류을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.cloth)?.setOnClickListener {
                Toast.makeText(this, "의류 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.cloth).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 스포츠을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.sport)?.setOnClickListener {
                Toast.makeText(this, "스포츠 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.sport).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 자동차을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.car)?.setOnClickListener {
                Toast.makeText(this, "자동차 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.car).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 서류를 클릭했을 때
            alertDialog.findViewById<Button>(R.id.document)?.setOnClickListener {
                Toast.makeText(this, "서류 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.document).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 악기을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.instrument)?.setOnClickListener {
                Toast.makeText(this, "악기 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.instrument).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 증명서을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.certification)?.setOnClickListener {
                Toast.makeText(this, "증명서 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.certification).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 기타을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.etc)?.setOnClickListener {
                Toast.makeText(this, "기타 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.etc).text.toString()
                binding.getCategoryArea.setText(category)

                alertDialog.dismiss()
            }
        }

        // 날짜를 입력받을 때 달력이 나오고 달력에서 날짜를 선택하면 선택한 날짜가 text로 들어간다.
        val datePickerListener1 = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            // 선택한 날짜를 원하는 형식으로 텍스트로 변환
            val selectedDateText = "${year}년 ${month + 1}월 ${dayOfMonth}일"

            // 선택한 날짜를 담아준다.
            selectedStartDay = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }

            // 선택을 취소했을 때
            if(selectedStartDay == null) {
                // 이전에 선택한 날짜를 담아준다.
                selectedStartDay = Calendar.getInstance().apply {
                    set(year, month, dayOfMonth)
                }
                return@OnDateSetListener
            }

            // 버튼의 텍스트를 선택한 날짜로 변경
            binding.getStartDate.text = selectedDateText
        }

        val datePickerListener2 = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            // 선택한 날짜를 원하는 형식으로 텍스트로 변환
            val selectedDateText = "${year}년 ${month + 1}월 ${dayOfMonth}일"

            // 선택한 날짜를 담아준다.
            selectedEndDay = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }

            // 선택을 취소했을 때
            if(selectedEndDay == null) {
                // 이전에 선택한 날짜를 담아준다.
                selectedEndDay = Calendar.getInstance().apply {
                    set(year, month, dayOfMonth)
                }
                return@OnDateSetListener
            }


            // 버튼의 텍스트를 선택한 날짜로 변경
            binding.getEndDate.text = selectedDateText
        }

        // 버튼 클릭 시 DatePickerDialog를 띄우는 코드
        binding.getStartDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val initialYear = calendar.get(Calendar.YEAR)
            val initialMonth = calendar.get(Calendar.MONTH)
            val initialDay = calendar.get(Calendar.DAY_OF_MONTH)

            // DatePickerDialog 생성
            val datePickerDialog = DatePickerDialog(this,
                datePickerListener1,
                initialYear,
                initialMonth,
                initialDay).apply{
                datePicker.maxDate = selectedEndDay.timeInMillis
            }

            datePickerDialog.show()
        }

        // 버튼 클릭 시 DatePickerDialog를 띄우는 코드
        binding.getEndDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val initialYear = calendar.get(Calendar.YEAR)
            val initialMonth = calendar.get(Calendar.MONTH)
            val initialDay = calendar.get(Calendar.DAY_OF_MONTH)

            // DatePickerDialog 생성
            val datePickerDialog = DatePickerDialog(
                this,
                datePickerListener2,
                initialYear,
                initialMonth,
                initialDay).apply {
                    datePicker.minDate = selectedStartDay.timeInMillis
                }

            datePickerDialog.show()
        }

        // 검색 버튼을 눌렀을 때 검색된 화면(SearchedActivity로 이동
        binding.searchBtn.setOnClickListener{


            // 시작일과 종료일이 비어있는지 확인
            if (binding.getStartDate.text.isEmpty() || binding.getEndDate.text.isEmpty()) {
                Toast.makeText(this, "시작일과 종료일을 선택해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val intent = Intent(this, SearchedGetActivity::class.java)
            intent.putExtra("카테고리명",binding.getCategoryArea.text.toString())
            intent.putExtra("시작일", binding.getStartDate.text.toString())
            intent.putExtra("종료일", binding.getEndDate.text.toString())
            startActivity(intent)
        }
    }
}