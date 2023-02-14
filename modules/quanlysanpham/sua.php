
<?php
	$sql = "select * from sanpham where id='$_GET[id]' ";
	$row=mysqli_query($conn,$sql);
	$dong=mysqli_fetch_array($row);
 ?>
<div class="button_themsp">
<a href="index.php?quanly=sanpham&ac=lietke">Liệt kê sp</a> 
</div>
<form action="modules/quanlysanpham/xuly.php?id=<?php echo $dong['id'] ?>" method="post" enctype="multipart/form-data">
<h3>&nbsp;</h3>
<table width="600" border="1">
  <tr>
    <td colspan="2" style="text-align:center;font-size:25px;">Sửa sản phẩm</td>
  </tr>
  <tr>
    <td width="97">Tên sản phẫm</td>
    <td width="87"><input type="text" name="tensp" value="<?php echo $dong['tensp'] ?>"></td>
  </tr>
  <tr>
    <td>Hình ảnh</td>
    <td><input type="file" name="hinhanh" /><img src="<?php echo $dong['hinhsp'] ?>" width="80" height="80"></td>
  </tr>
  <tr>
    <td>Giá </td>
    <td><input type="text" name="giadexuat" value="<?php echo $dong['giasp'] ?>"></td>
  </tr>
  <tr>
    <td>Nội dung</td>
    <td><textarea name="noidung" cols="40" rows="10"><?php echo $dong['motasp'] ?></textarea></td>
  </tr>
  <tr>
  <?php
  $sql_loaisp = "select * from loaisp";
  $row_loaisp=mysqli_query($conn,$sql_loaisp);
  ?>
    <td>Loại sản phẩm</td>
    <td><select name="tenloaisp">
     <?php
	while($dong_loaisp=mysqli_fetch_array($row_loaisp)){
		if($dong['loaisp']==$dong_loaisp['id']){
	?>
    	<option selected="selected" value="<?php echo $dong_loaisp['idloaisp'] ?>"><?php echo $dong_loaisp['tenloaisp'] ?></option>
        <?php
	}else{
		?>
       <option value="<?php echo $dong_loaisp['idloaisp'] ?>"><?php echo $dong_loaisp['tenloaisp'] ?></option>
        <?php
	}
	}
		?>
    </select></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">
      <input type="submit" name="sua" value="Sửa sản phẩm">
    </div></td>
  </tr>
</table>
</form>


