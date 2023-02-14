<?php 
	include "connect.php";
	$tenkhachhang = $_POST['tenkhachhang'];
	$diachi = $_POST['diachi'];
	$sdt = $_POST['sdt'];
	if(strlen($tenkhachhang) > 0 && strlen($diachi) > 0 && strlen($sdt) > 0){
		$query = "INSERT INTO hoadon(tenkhachhang,diachi,sdt) VALUES ('$tenkhachhang','$diachi',$sdt)"; 
		if(mysqli_query($conn,$query)){
			$idhoadon = $conn->insert_id;
			echo $idhoadon;
		}else{
			echo "Thất Bại";
		}
	}else{
		echo "Bạn Hãy Kiểm Tra Lại Các Dữ liệu";
	}
?>