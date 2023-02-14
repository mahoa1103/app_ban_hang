<?php 
	include "connect.php";
	$json = $_POST['jsondn'];
	$data = json_decode($json,true);
	foreach ($data as  $value) {
		$taikhoan = $value['taikhoan'];
		$matkhau = $value['matkhau'];
		$query = "SELECT * FROM nguoidung WHERE taikhoan='$taikhoan' AND matkhau='$matkhau'";
		$Dta = mysqli_query($conn,$query);
		}
	if($Dta){
		echo "1";
	}else{
		echo "0";	
	}
?>	