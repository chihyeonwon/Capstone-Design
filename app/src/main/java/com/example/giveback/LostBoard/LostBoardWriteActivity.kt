package com.example.giveback.LostBoard

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giveback.GalleryAdapter
import com.example.giveback.LostBoard.LostBoardModel
import com.example.giveback.MainActivity
import com.example.giveback.R
import com.example.giveback.WebviewActivity
import com.example.giveback.databinding.ActivityLostBoardWriteBinding
import com.example.giveback.utils.FBAuth
import com.example.giveback.utils.FBRef
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.Calendar

// 게시글 작성 페이지
class LostBoardWriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLostBoardWriteBinding

    private val TAG = LostBoardWriteActivity::class.java.simpleName

    private var isImageUpload = false

    val user = FirebaseAuth.getInstance().currentUser
    val email = user?.email.toString()

    private lateinit var dialog: Dialog

    private lateinit var category: String

    private lateinit var count: Number

    private val maxNumber = 5

    lateinit var galleryAdapter: GalleryAdapter

    var imageList: ArrayList<Uri> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_lost_board_write)

        //adapter 초기화
        galleryAdapter = GalleryAdapter(imageList, this)

        //recyclerView 설정
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        binding.recyclerView.adapter = galleryAdapter


        // 카테고리를 선택해주세요 버튼을 눌렀을 때 카테고리 설정 창으로 이동한다.
        binding.lostCategoryArea.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.category_item, null)
            val mBuilder = android.app.AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("카테고리 설정창")

            val alertDialog = mBuilder.show()

            // 지갑을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.wallet)?.setOnClickListener {
                Toast.makeText(this, "지갑 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.wallet).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 카드을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.card)?.setOnClickListener {
                Toast.makeText(this, "카드 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.card).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 현금을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.cash)?.setOnClickListener {
                Toast.makeText(this, "현금 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.cash).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 가방을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.bag)?.setOnClickListener {
                Toast.makeText(this, "가방 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.bag).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 전자기기을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.device)?.setOnClickListener {
                Toast.makeText(this, "전자기기 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.device).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 의류을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.cloth)?.setOnClickListener {
                Toast.makeText(this, "의류 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.cloth).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 스포츠을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.sport)?.setOnClickListener {
                Toast.makeText(this, "스포츠 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.sport).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 자동차을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.car)?.setOnClickListener {
                Toast.makeText(this, "자동차 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.car).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 서류를 클릭했을 때
            alertDialog.findViewById<Button>(R.id.document)?.setOnClickListener {
                Toast.makeText(this, "서류 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.document).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 악기을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.instrument)?.setOnClickListener {
                Toast.makeText(this, "악기 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.instrument).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 증명서을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.certification)?.setOnClickListener {
                Toast.makeText(this, "증명서 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.certification).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }

            // 기타을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.etc)?.setOnClickListener {
                Toast.makeText(this, "기타 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.etc).text.toString()
                binding.lostCategoryArea.setText(category)

                alertDialog.dismiss()
            }
        }

        // 분실 위치 옆의 물음표 버튼을 눌렀을 때 학교 건물 웹뷰로 이동한다.
        binding.question.setOnClickListener {
            val intent = Intent(this, WebviewActivity::class.java)
            startActivity(intent)
        }

        // 날짜를 입력받을 때 달력이 나오고 달력에서 날짜를 선택하면 선택한 날짜가 text로 들어간다.
        val datePickerListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            // 선택한 날짜를 원하는 형식으로 텍스트로 변환
            val selectedDateText = "${year}년 ${month + 1}월 ${dayOfMonth}일"

            // 버튼의 텍스트를 선택한 날짜로 변경
            binding.lostDateArea.text = selectedDateText
        }

        // 버튼 클릭 시 DatePickerDialog를 띄우는 코드
        binding.lostDateArea.setOnClickListener {
            val calendar = Calendar.getInstance()
            val initialYear = calendar.get(Calendar.YEAR)
            val initialMonth = calendar.get(Calendar.MONTH)
            val initialDay = calendar.get(Calendar.DAY_OF_MONTH)

            // DatePickerDialog 생성
            val datePickerDialog = DatePickerDialog(this, datePickerListener, initialYear, initialMonth, initialDay)
            datePickerDialog.show()
        }

        // 분실위치와 관련한 드롭다운 메뉴 코드입니다.
        // R.id.gender_spinner 는 1번에서 지정한 Spinner 태그의 ID 입니다.
        val lostSpinner: Spinner = findViewById(R.id.lostlocationArea)

        ArrayAdapter.createFromResource(
            this,

            // 설정한 string-array 태그의 name 입니다.
            R.array.location_array,

            // android.R.layout.simple_spinner_dropdown_item 은 android 에서 기본 제공
            // 되는 layout 입니다. 이 부분은 "선택된 item" 부분의 layout을 결정합니다.
            R.layout.getlocation_spinner_item

        ).also { adapter ->

            // android.R.layout.simple_spinner_dropdown_item 도 android 에서 기본 제공
            // 되는 layout 입니다. 이 부분은 "선택할 item 목록" 부분의 layout을 결정합니다.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            lostSpinner.adapter = adapter
        }

        val detaillost = binding.detaillostArea.text

        dialog = Dialog(this)

        // 게시글 작성 버튼을 눌렀을 때 파이어베이스에 게시글과 이미지를 넣는다.
        binding.writeBtn.setOnClickListener {

            // uid를 가져온다.
            val uid = FBAuth.getUid()

            val lostUid = uid.toString()
            val title = binding.titleArea.text.toString()
            val category = binding.lostCategoryArea.text.toString()
            val content = binding.contentArea.text.toString()
            val lostDate = binding.lostDateArea.text.toString()
            val lostLocation = lostSpinner.selectedItem.toString()
            val lostdetailLocation = binding.detaillostArea.text.toString()

            // 키부터 생성하고 데이터베이스에 저장하도록 수정
            val key = FBRef.lostboardRef.push().key.toString()


            // 분실명은 필수로 입력되어야 한다.
            if(title.isEmpty()){
                Toast.makeText(this,"분실물명을 선택해주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 분실날짜는 필수로 입력되어야 한다.
            if(lostDate.isEmpty()){
                Toast.makeText(this,"분실날짜를 선택해주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 카테고리는 필수로 입력되어야 한다.(검색과 키워드에 사용되기 때문이다.)
            if(category.isEmpty()){
                Toast.makeText(this,"카테고리를 선택해주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val alertDialog = AlertDialog.Builder(this)
                .setIcon(R.drawable.chat)
                .setTitle("분실물 게시글 등록")
                .setMessage("등록된 게시글은 2024-05-05까지 유지되며 그 이후 자동으로 삭제됩니다.")
                .setPositiveButton("확인") { dialog, which ->
                    // 파이어 베이스에 데이터를 저장한다.
                    FBRef.lostboardRef
                        .child(key) // 랜덤한 값
                        .setValue(
                            LostBoardModel(
                                uid,
                                email,
                                title,
                                category,
                                lostDate,
                                lostLocation,
                                lostdetailLocation,
                                content
                            )
                        )

                    Toast.makeText(this,"게시글 입력 완료", Toast.LENGTH_SHORT).show()

                    // 선택된 이미지 수만큼 업로드하도록 수정
                    for (i in 0 until imageList.count()) {
                        imageUpload(key, imageList.get(i), i)
                    }

                    // 작성이 끝나면 MainActivity로 이동한다.
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("취소", null)
                .create()
            alertDialog.show()
        }

        // 이미지 업로드 버튼을 클릭했을 때 이미지를 업로드한다.
        binding.imageUploadBtn.setOnClickListener {
            showImageUploadDialog()
        }
    }

    // 이미지를 업로드하는 함수
    private fun imageUpload(key:String, uri:Uri, count: Int) {
        val storage = Firebase.storage
        val storageRef = storage.reference
        val mountainsRef = storageRef.child("${key}${count}.png")


        // 이미지 업로드
        val imageView = findViewById<ImageView>(R.id.galleryView)
        imageView.isDrawingCacheEnabled = true
        imageView.buildDrawingCache()

        val uploadTask = mountainsRef.putFile(uri)

        uploadTask.addOnFailureListener {
            // 업로드 실패 처리
        }
    }

    private fun showImageUploadDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_image_upload) // dialog_image_upload.xml 파일을 생성해주세요

        // 카메라로 사진 찍기 버튼 클릭 시
        val cameraButton = dialog.findViewById<Button>(R.id.cameraButton)
        cameraButton.setOnClickListener {

            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this@LostBoardWriteActivity,
                android.Manifest.permission.CAMERA
            )
            if (cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) { // 권한이 없는 경우
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else { //권한이 있는 경우
                cameraIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(cameraIntent, 200)
                    isImageUpload = true
                    dialog.dismiss()
                }
            }
        }

        // 갤러리에서 사진 선택 버튼 클릭 시
        val galleryButton = dialog.findViewById<Button>(R.id.galleryButton)
        galleryButton.setOnClickListener {

            if (imageList.count() == maxNumber) {
                Toast.makeText(
                    this,
                    "이미지는 최대 ${maxNumber}장까지 첨부할 수 있습니다.",
                    Toast.LENGTH_SHORT
                ).show();
                return@setOnClickListener
            }

            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)

            // 사진 멀티 선택 가능
            gallery.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(gallery, 100)
            isImageUpload = true
            dialog.dismiss()
        }

        // close이미지 클릭 시
        val closeBtn = dialog.findViewById<ImageView>(R.id.closeBtn)
        closeBtn.setOnClickListener {
            dialog.dismiss()
        }

        // close버튼 클릭 시
        val closeButton = dialog.findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener {
            dialog.dismiss()
        }

        // 다이얼로그 띄우기
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && requestCode == 100) {

            //멀티 선택은 clipData
            if(data!!.clipData != null){ //멀티 이미지

                //선택한 이미지 갯수
                count = data!!.clipData!!.itemCount

                for(index in 0 until count as Int){
                    //이미지 담기
                    val imageUri = data!!.clipData!!.getItemAt(index).uri
                    //이미지 추가
                    imageList.add(imageUri)
                }

                Log.d(TAG, "현재 선택한 사진 수 : ${count.toString()}")

            }else{ //싱글 이미지
                val imageUri = data!!.data
                imageList.add(imageUri!!)
            }
            galleryAdapter.notifyDataSetChanged()

        } else if(resultCode == RESULT_OK && requestCode == 200) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            findViewById<ImageView>(R.id.galleryView).setImageBitmap(imageBitmap)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) { //거부
                Toast.makeText(this@LostBoardWriteActivity, "카메라 권한을 허용하고 이용해주세요 ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}