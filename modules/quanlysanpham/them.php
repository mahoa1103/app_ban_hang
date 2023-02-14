
<div class="button_themsp">
<a href="index.php?quanly=sanpham&ac=lietke">Liệt kê sp</a> 
</div>
<form action="modules/quanlysanpham/xuly.php" method="post" enctype="multipart/form-data">
<h3>&nbsp;</h3>
<table width="600" border="1">
  <tr>
    <td colspan="2" style="text-align:center;font-size:25px;">Thêm  sản phẩm</td>
  </tr>
  <tr>
    <td width="97">Tên sản phẩm</td>
    <td width="87"><input type="text" name="tensp"></td>
  </tr>
  <tr>
    <td>Hình ảnh</td>
    <td><input type="file" name="hinhanh" /></td>
  </tr>
  <tr>
    <td>Giá</td>
    <td><input type="text" name="giasp"></td>
  </tr>
  <tr>
    <td>Nội dung</td>
    <td><textarea name="motasp" cols="40" rows="10"></textarea></td>
  </tr>
  <tr>
  <?php
  $sql_loaisp = "select id,tenloaisp from loaisp";
  $row_loaisp=mysqli_query($conn,$sql_loaisp);
  ?>
    <td>Loại sản phẩm</td>
    <td><select name="loaisp">
    <?php
	while($dong_loaisp=mysqli_fetch_array($row_loaisp)){
	?>
    	<option value="<?php echo $dong_loaisp['id'] ?>"><?php echo $dong_loaisp['tenloaisp'] ?></option>
        <?php
	}
		?>
    </select></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">
      <input type="submit" name="them" value="Thêm sản phẩm">
    </div></td>
  </tr>
</table>
</form>


