
<?php
	if(isset($_POST['timkiem'])){
	$search=$_POST['masp'];
	echo 'Mã tìm kiếm :<strong>'.' '.$search.'</strong><br/>';
	$sql_timkiem="select * from sanpham,loaisp where sanpham.idloaisp=loaisp.id and  tensp='".$search."'";
	$row_timkiem=mysqli_query($conn,$sql_timkiem);
	$count=mysqli_num_rows($row_timkiem);
	if($count>0){
	
?>
<h3>Kết quả tìm kiếm</h3>

<table width="100%" border="1">
  <tr>
    <td>STT</td>
    <td>Tên sản phẩm</td>
    <td>Hình ảnh</td>
    <td>Giá sản phẩm</td>
    <td>Loại hàng</td>
    <td colspan="2">Quản lý</td>
  </tr>
  <?php
  $i=1;
  while($dong=mysql_fetch_array($row_timkiem)){

  ?>
  <tr>
    <td><?php  echo $i;?></td>
    <td><?php echo $dong['tensp'] ?></td>
    <td><img src="<?php echo $dong['hinhanh'] ?>" width="80" height="80" /></td>
    <td><?php echo $dong['giadexuat'] ?></td>
    <td><?php echo $dong['giasp'] ?></td>
    <td><?php
    $row = mysqli_fetch_array(mysqli_query($conn,"select * from loaisp where id = ".$dong['idloaisp'])); 
    echo $row['tenloaisp'] 
      ?></td>
    <td><a href="index.php?quanly=sanpham&ac=sua&id=<?php echo $dong['idsanpham'] ?>"><center><img src="../imgs/edit.png" width="30" height="30" /></center></a></td>
    <td><a href="modules/quanlysanpham/xuly.php?id=<?php echo $dong['idsanpham']?>"><center><img src="../imgs/delete.png" width="30" height="30" /></center></a></td>
  </tr>
  <?php
  $i++;
  }
	}else{
	  echo 'Không tìm thấy kết quả';
  }
  }
  ?>
</table>
