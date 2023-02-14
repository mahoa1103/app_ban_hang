<?php 
	include "connect.php";
	$json = $_POST['json'];
	$data = json_decode($json,true);
	foreach ($data as  $value) {
		$idhoadon = $value['idhoadon'];
		$idsanpham = $value['idsp'];
		$tensanpham = $value['tensanpham'];
		$soluongsanpham = $value['soluong'];
		$giatien = $value['giatien'];
		$query = "INSERT INTO chitiethd(idHD,idsp,tensanpham,soluong,giatien) VALUES ($idhoadon,$idsanpham,'$tensanpham',$soluongsanpham,$giatien)";
		$Dta = mysqli_query($conn,$query);
	}
	if($Dta){
		echo "1";
	}else{
		echo "0";
	}
?>	