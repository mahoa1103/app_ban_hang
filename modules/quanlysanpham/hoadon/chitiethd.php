
<?php
  include('connect.php');
	if(isset($_GET['id'])){
		$idhoadon = $_GET['id'];
	}
	$sql_chitiethd = "select * from chitiethd where idHD=".$idhoadon;
	$row_chitiethd = mysqli_query($conn,$sql_chitiethd);

?>
<div class="button_themsp">
<a href="index.php?quanly=hoadon&ac=lietke">Hóa đơn</a> 
</div>
<table width="100%" border="1">
  <tr>
    <td>STT</td>
    <td>Tên sản phẩm</td>
    <td>Hình ảnh</td>
    <td>Giá </td>
    <td>Số lượng</td>
  </tr>
  <?php
  $i=1;
  while($dong=mysqli_fetch_array($row_chitiethd)){

  ?>
  <tr>
  	
    <td><?php  echo $i;?></td>
    <td><?php echo $dong['tensanpham'] ?></td>
    <td>
    <?php
    	$rowhd = mysqli_fetch_array(mysqli_query($conn,"select * from sanpham where id =".$dong['idsp'])); 
   
    ?>
    	<img src="<?php echo $rowhd['hinhsp'] ?>" width="80" height="80" />
    </td>
    <td><?php echo number_format($dong['giatien']) ?></td>
    <td><?php echo $dong['soluong'] ?></td>

  </tr>
  <?php
  $i++;
  }
  ?>
</table>