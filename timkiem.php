<?php 
	include "connect.php";
	$page = $_GET['page'];
	$tukhoa = $_POST['tukhoa'];
	$space = 5;
	$limit = ($page - 1) *$space;
	$mangtimkiem = array();
	$query = "SELECT * FROM sanpham WHERE tensp LIKE '%$tukhoa%' LIMIT $limit,$space";
	$data = mysqli_query($conn,$query);
	while ($row = mysqli_fetch_assoc($data)){
		array_push($mangtimkiem,new Timkiem(
			$row['id'],
			$row['tensp'],
			$row['giasp'],
			$row['hinhsp'],
			$row['motasp'],
			$row['idloaisp']));
	}
	echo json_encode($mangtimkiem);

	class Timkiem{
		function Timkiem($id,$tensp,$giasp,$hinhsp,$motasp,$idloaisp){
			$this->id = $id;
			$this->tensp = $tensp;
			$this->giasp = $giasp;
			$this->hinhsp = $hinhsp;
			$this->motasp = $motasp;
			$this->idloaisp = $idloaisp;
		}
	}
?>