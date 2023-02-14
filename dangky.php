<?php 
	include "connect.php";
	$json = $_POST['jsondk'];
	$data = json_decode($json,true);
	foreach ($data as  $value) {
		$taikhoan = $value['taikhoan'];
		$matkhau = $value['matkhau'];
		$query = "INSERT INTO nguoidung(taikhoan,matkhau,quyen) VALUES ('$taikhoan','$matkhau','khách hàng')";
		$Dta = mysqli_query($conn,$query);
	}
	if($Dta){
		echo "1";
	}else{
		echo "0";
	}
?>	