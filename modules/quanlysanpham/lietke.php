
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
	$sql_lietkesp="select * from sanpham order by id desc limit $trang1,5 ";
	$row_lietkesp=mysqli_query($conn,$sql_lietkesp);

?>
<div class="button_themsp">
<a href="index.php?quanly=sanpham&ac=them">Thêm Mới</a> 
</div>

<table width="100%" border="1">
  <tr>
    <td>STT</td>
    <td>Tên sản phẩm</td>
    <td>Hình ảnh</td>
    <td>Giá </td>
    <td>Loại hàng</td>
    <td colspan="2">Quản lý</td>
  </tr>
  <?php
  $i=1;
  while($dong=mysqli_fetch_array($row_lietkesp)){

  ?>
  <tr>
  	
    <td><?php  echo $i;?></td>
    <td><?php echo $dong['tensp'] ?></td>
    <td><img src="<?php echo $dong['hinhsp'] ?>" width="80" height="80" /></td>
    <td><?php echo number_format($dong['giasp']) ?></td>
    <td><?php
    $row = mysqli_fetch_array(mysqli_query($conn,"select * from loaisp where id = ".$dong['idloaisp'])); 
    echo $row['tenloaisp'] 
  		?></td>
    <td><a href="index.php?quanly=sanpham&ac=sua&id=<?php echo $dong['id'] ?>" ><center><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Edit_icon_%28the_Noun_Project_30184%29.svg/1024px-Edit_icon_%28the_Noun_Project_30184%29.svg.png" width="30" height="30" /></center></a></td>
    <td><a href="modules/quanlysanpham/xuly.php?id=<?php echo $dong['id']?>" class="delete_link"><center><img src="https://cdn.iconscout.com/icon/premium/png-512-thumb/delete-1432400-1211078.png" width="30" height="30"   /></center></a></td>
  </tr>
  <?php
  $i++;
  }
  ?>
</table>
<div class="trang">
	Trang :
    <?php
	$sql_trang=mysqli_query($conn,"select * from sanpham");
	$count_trang=mysqli_num_rows($sql_trang);
	$a=ceil($count_trang/5);
	for($b=1;$b<=$a;$b++){
		
		if($trang==$b){
		
		echo '<a href="index.php?quanly=sanpham&ac=lietke&trang='.$b.'" style="text-decoration:underline;color:red;">'.$b.' ' .'</a>';
        
	}else{
		echo '<a href="index.php?quanly=sanpham&ac=lietke&trang='.$b.'" style="text-decoration:none;color:#000;">'.$b.' ' .'</a>';
	}
	}
	?>
</div>
