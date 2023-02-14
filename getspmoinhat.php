<?php 
	include "connect.php";
	$mangspmoinhat = array();
	$query = "SELECT * FROM sanpham ORDER BY id DESC LIMIT 6";
	$data = mysqli_query($conn,$query);
	while ($row = mysqli_fetch_assoc($data)){
		array_push($mangspmoinhat,new SPmoinhat(
			$row['id'],
			$row['tensp'],
			$row['giasp'],
			$row['hinhsp'],
			$row['motasp'],
			$row['idloaisp']));
	}
	echo json_encode($mangspmoinhat);
	class SPmoinhat{
		function SPmoinhat($id,$tensp,$giasp,$hinhsp,$motasp,$idloaisp){
			$this->id = $id;
			$this->tensp = $tensp;
			$this->giasp = $giasp;
			$this->hinhsp = $hinhsp;
			$this->motasp = $motasp;
			$this->idloaisp = $idloaisp;
		}
	}
?>