<?php 
	include "connect.php";
	$page = $_GET['page'];
	$idloaisp = $_POST['idloaisp'];
	$space = 5;
	$limit = ($page - 1) *$space;
	$mangsanpham = array();
	$query = "SELECT * FROM sanpham WHERE idloaisp = $idloaisp LIMIT $limit,$space";
	$data = mysqli_query($conn,$query);
	while ($row = mysqli_fetch_assoc($data)){
		array_push($mangsanpham,new Sanpham(
			$row['id'],
			$row['tensp'],
			$row['giasp'],
			$row['hinhsp'],
			$row['motasp'],
			$row['idloaisp']));
	}
	echo json_encode($mangsanpham);

	class Sanpham{
		function Sanpham($id,$tensp,$giasp,$hinhsp,$motasp,$idloaisp){
			$this->id = $id;
			$this->tensp = $tensp;
			$this->giasp = $giasp;
			$this->hinhsp = $hinhsp;
			$this->motasp = $motasp;
			$this->idloaisp = $idloaisp;
		}
	}
?>