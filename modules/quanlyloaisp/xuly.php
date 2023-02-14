<?php
	include('connect.php');
	$tenloaisp=$_POST['loaisp'];
	
	if(isset($_POST['them'])){
		//them
		$sql_them=("insert into loaisp (tenloaisp,hinhloaisp) value('$tenloaisp','$hinhanh')");
		mysqli_query($conn,$sql_them);
		header('location:../../index.php?quanly=loaisp&ac=lietke');
	}elseif(isset($_POST['sua'])){
		//sua
		$sql_sua = "update loaisp set tenloaisp='$tenloaisp',tinhtrang='$tinhtrang' where idloaisp='$_GET[id]'";
		mysqli_query($conn,$sql_sua);
		header('location:../../index.php?quanly=loaisp&ac=lietke');
	}else{
		$sql_xoa = "delete from loaisp where idloaisp = $_GET[id]";
		mysqli_query($conn,$sql_xoa);
		header('location:../../index.php?quanly=loaisp&ac=lietke');
	}
?>
