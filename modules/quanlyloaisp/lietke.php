<?php
	$sql_lietkesp="select * from loaisp order by id desc ";
	$row_lietkesp=mysqli_query($conn,$sql_lietkesp);

?>
<div class="button_themsp">
<a href="index.php?quanly=loaisp&ac=them">Thêm Mới</a> 
</div>

<table width="100%" border="1">
  <tr>
    <td>ID</td>
    <td>Tên loại sản phẩm</td>
    <td>Hình loại sản phẩm</td>
    <td colspan="2">Quản lý</td>
  </tr>
  <?php
  $i=1;
  while($dong=mysqli_fetch_array($row_lietkesp)){

  ?>
  <tr>
    <td><?php  echo $i;?></td>
    <td><?php echo $dong['tenloaisp'] ?></td>
    <td><img src="<?php echo $dong['hinhloaisp'] ?>" width="80" height="80" /></td>
    <td><a href="index.php?quanly=loaisp&ac=sua&id=<?php echo $dong['id'] ?>"><center><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Edit_icon_%28the_Noun_Project_30184%29.svg/1024px-Edit_icon_%28the_Noun_Project_30184%29.svg.png" width="30" height="30" /></center></a></td>
    <td><a href="modules/quanlyloaisp/xuly.php?id=<?php echo $dong['id']?>" class="delete_link"><center><img src="https://cdn.iconscout.com/icon/premium/png-512-thumb/delete-1432400-1211078.png" width="30" height="30" /></center></a></td>
  </tr>
  <?php
  $i++;
  }
  ?>
</table>
