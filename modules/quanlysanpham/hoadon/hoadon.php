
<?php
	if(isset($_GET['trang'])){
		$trang=$_GET['trang'];
	}else{
		$trang='';
	}
	if($trang =='' || $trang =='1'){
		$trang1=0;
	}else{
		$trang1=($trang*5)-5;
	}
	$sql_lietkesp="select * from hoadon order by id desc limit $trang1,5 ";
	$row_lietkesp=mysqli_query($conn,$sql_lietkesp);

?>

<table width="100%" border="1">
  <tr>
    <td>STT</td>
    <td>Tên khách hàng</td>
    <td>Địa Chỉ</td>
    <td>SĐT</td>
    <td>Thời gian</td>
    <td>Tổng tiền</td>
    <td>Chi tiết</td>
  <?php
  $i=1;
  while($dong=mysqli_fetch_array($row_lietkesp)){
  ?>
  <tr>
  	
    <td><?php  echo $i;?></td>
    <td><?php echo $dong['tenkhachhang'] ?></td>
    <td><?php echo $dong['diachi'] ?></td>
    <td><?php echo "0".$dong['sdt'] ?></td>
    <td><?php echo $dong['thoigian'] ?></td>
    <td>
    	<?php 
    		$tongtien = 0;
    		$sql_tongtien = "select * from chitiethd order by idHD =".$dong['id'];
    		$row_tongtien = mysqli_query($conn,$sql_tongtien);
    		while($rowtt = mysqli_fetch_array($row_tongtien)){
    			$tongtien = $tongtien + ($rowtt['soluong'] * $rowtt['giatien']);
    		}
    		echo number_format($tongtien) 
  		?>
  	</td>
    <td><a href="index.php?quanly=hoadon&ac=chitiet&id=<?php echo $dong['id'] ?>">Chi tiết</a></td>
  </tr>
  <?php
  $i++;
  }
  ?>
</table>
<div class="trang">
	Trang :
    <?php
	$sql_trang=mysqli_query($conn,"select * from hoadon");
	$count_trang=mysqli_num_rows($sql_trang);
	$a=ceil($count_trang/5);
	for($b=1;$b<=$a;$b++){
		
		if($trang==$b){
		
		echo '<a href="index.php?quanly=hoadon&ac=lietke&trang='.$b.'" style="text-decoration:underline;color:red;">'.$b.' ' .'</a>';
        
	}else{
		echo '<a href="index.php?quanly=hoadon&ac=lietke&trang='.$b.'" style="text-decoration:none;color:#000;">'.$b.' ' .'</a>';
	}
	}
	?>
</div>
