<?php
	if(isset($_POST['logout'])){
		unset($_SESSION['dangnhap']);
		header('location:login.php');
	}
?>
<div class="menu">
    	<ul>
        	<li><a href="index.php?quanly=loaisp&ac=lietke">Quản lý loại sp</a></li>
            <li><a href="index.php?quanly=sanpham&ac=lietke">Quản lý sản phẩm</a></li>
            <li><a href="index.php?quanly=nguoidung&ac=lietke">Danh sách User</a></li>
            <li><a href="index.php?quanly=hoadon&ac=lietke">Danh sách hóa đơn</a></li> 
            <li>admin</li>
            <form action="" method="post" enctype="multipart/form-data">

            <input type="submit" name="logout" value="Đăng xuất" style="background:#06F;color:#fff;width:200px;height:30px;" />
            </form>
        </ul>
       
    </div>

 <form action="index.php?quanly=timkiem&ac=sp" method="post" enctype="multipart/form-data">
     <p><input type="text" name="masp" placeholder="Nhập tên sản phẩm..." id="timkiem" required="required" />
        <input type="submit" id="button_timkiem" name="timkiem" value="Tìm sản phẩm" />
        </p>
        </form>