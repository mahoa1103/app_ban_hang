<?php
	include('connect.php');
	$tensp=$_POST['tensp'];
	$hinhanh=$_FILES['hinhanh']['name'];
	$hinhanh_tmp=$_FILES['hinhanh']['tmp_name'];
	move_uploaded_file($hinhanh_tmp,'uploads/'.$hinhanh);
	$giasp=$_POST['giasp'];
	$noidung=$_POST['motasp'];
	$idloaisp=$_POST['idloaisp'];
	$trang=$_GET['trang'];
	
	if(isset($_POST['them'])){
		//them
		 $sql_them=("insert into sanpham (tensp,giasp,hinhsp,motasp,idloaisp) value('$tensp','$hinhanh','$giasp','$noidung',$idloaisp)");
		mysqli_query($conn,$sql_them);
		header('location:../../index.php?quanly=sanpham&ac=lietke');
	}elseif(isset($_POST['sua'])){
		//sua
		if($hinhanh!=''){
	  $sql_sua = "update sanpham set tensp='$tensp',giasp='$giasp',,hinhsp='$hinhanh',motasp='$noidung',idloaisp=$idloaisp where id='$_GET[id]'";
		}else{
			$sql_sua = "update sanpham set tensp='$tensp',giasp='$giasp',motasp='$noidung',idloaisp=$idloaisp where id='$_GET[id]'";
		}
		mysqli_query($conn,$sql_sua);
		header('location:../../index.php?quanly=sanpham&ac=lietke');
	}else{
		$sql_xoa = "delete from sanpham where id = $_GET[id]";
		mysqli_query($conn,$sql_xoa);
		header('location:../../index.php?quanly=sanpham&ac=lietke');
	}
?>
