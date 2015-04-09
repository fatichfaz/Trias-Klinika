package coba;

import javax.swing.JOptionPane;

public class method {
    class TreeNode {
        TreeNode kiri;
        TreeNode kanan;
        int data;
    }
    TreeNode root;
    TreeNode current;
    TreeNode temp;
    TreeNode home;
    TreeNode door;
    int level = 0;
    String a = "Kiri";
    String b = "Kanan";
    String c;
    String d;
    String e;
    
    public boolean kosong(){
        return (root ==  null);
    }
    
    public void add(int a){
        if(kosong()){
            TreeNode databaru = new TreeNode();
            databaru.data=a;
            root = current  = home = databaru;
            JOptionPane.showMessageDialog(null,"Berhasil Menambahkan Data","Penambahan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if(a<current.data){
            temp = current.kiri;
            if(temp==null){
                TreeNode databaru = new TreeNode();
                databaru.data=a;
                current.kiri=databaru;
                JOptionPane.showMessageDialog(null,"Berhasil Menambahkan Data","Penambahan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                current = current.kiri;
                add(a); 
            }    
        }
        
        else if(a>current.data){
            temp = current.kanan;
            if(temp==null){
                TreeNode databaru = new TreeNode();
                databaru.data=a;
                current.kanan=databaru;
                JOptionPane.showMessageDialog(null,"Berhasil Menambahkan Data","Penambahan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                current = current.kanan;
                add(a); 
            }  
        }
        
        else if (a == current.data) {
            JOptionPane.showMessageDialog(null, "Maaf Tidak Boleh Ada Data yang Sama","Penambahan Data Gagal", JOptionPane.ERROR_MESSAGE);
        }
        current = root;
        }
    
    public void cari(int key) {
        if (kosong()) {
            JOptionPane.showMessageDialog(null, "Maaf Data Masih Kosong","Pencarian Data Gagal", JOptionPane.ERROR_MESSAGE);
        }
        
        else if (key == root.data) {
            JOptionPane.showMessageDialog(null, "Data "+key+" Berada di Level "+level+" Sebagai Root","Pencarian Data Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if (current == null) {
            JOptionPane.showMessageDialog(null, "Maaf Data Tidak Ada Dalam Daftar","Pencarian Data Gagal", JOptionPane.ERROR_MESSAGE);
        }
        
        else if (key == current.data) {
            JOptionPane.showMessageDialog(null, "Data "+key+" Berada di Level "+level+" Sub Tree "+c+" Bagian "+d,"Pencarian Data Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if (key < current.data) {
            if (level == 0) {
                c = a;
            }
            current = current.kiri;
            level++;
            d = a;
            cari (key);
        }
        
        else if (key > current.data) {
            if (level == 0) {
                c = b;
            }
            current = current.kanan;
            level++;
            d = b;
            cari (key);
        }
 
        current =   root;
        level = 0;
    }
    
    public String arah =  "";
    public void pointer(int key) {
        if (kosong()) {
            e = "kosong";
            arah = arah + e + " ";
        }
        else if (current == null) {
            e = "tidak ada"+" ";
            arah = arah + e + " ";
        }
        else if (key != current.data) {
            if (key < current.data) {
                e = a;
                current = current.kiri;
            }
            else {
                e = b;                          
                current = current.kanan;
            }
            arah = arah + e + " ";
            pointer (key);
        }
        else if (key == root.data) {
            e = "root";
            arah = arah + e + " ";
        }
        else if (key == current.data) {
            e = "ketemu";
            arah = arah + e + " ";
        }
}
    
    public void hapus(int key) {
        if (kosong()) {
            JOptionPane.showMessageDialog(null, "Maaf Data Masih Kosong","Penghapusan Data Gagal", JOptionPane.ERROR_MESSAGE);
        }
        
        else if (key == root.data) {
            if (root.kanan == null & root.kiri == null) {
                root = null;
                JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data","Penghapusan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
            
            else if (root.kanan != null) {
                temp = current.kanan;
                hapusroot();
                temp.kiri = root.kiri;
                if (root.kanan != temp) {
                    temp.kanan = root.kanan;
                }
                root.kiri = root.kanan = null;
                root = temp;
                current = home = root;
                JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data","Penghapusan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
            
            else if (root.kiri != null) {
                temp = current.kiri;
                hapusroot();
                if (root.kiri != temp) {
                    temp.kiri = root.kiri;
                }
                temp.kanan = root.kanan;
                root.kiri = root.kanan = null;
                root = temp;
                current = home = root;
                JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data","Penghapusan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        else if (key < home.data) {
            door = home.kiri;
            if (door == null) {
                JOptionPane.showMessageDialog(null, "Maaf Data Tidak Ada dalam Daftar","Penghapusan Data Gagal", JOptionPane.ERROR_MESSAGE);
            }
            else if (key == door.data) {
                if (door.kanan == null & door.kiri == null) {
                    home.kiri = null;
                    current = home = root;
                    JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data","Penghapusan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            
                else if (door.kanan != null) {
                    current = door;
                    temp = current.kanan;
                    hapusnode();
                    temp.kiri = door.kiri;
                    if (temp.data != door.kanan.data) {
                        temp.kanan = door.kanan;
                    }
                    door.kiri = door.kanan = null;
                    if (home.data < temp.data) {
                        home.kanan = temp;
                    }
                    else {
                        home.kiri = temp;
                    }
                    current = home = root;
                    JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data","Penghapusan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            
                else if (door.kiri != null) {
                    current = door;
                    temp = current.kiri;
                    hapusnode();
                    if (temp.data != door.kiri.data) {
                        temp.kiri = door.kiri;
                    }
                    temp.kanan = door.kanan;
                    door.kiri = door.kanan = null;
                    if (home.data < temp.data) {
                        home.kanan = temp;
                    }
                    else {
                        home.kiri = temp;
                    }
                    current = home = root;
                    JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data","Penghapusan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else {
                home = home.kiri;
                hapus (key);
            }
        }
        
        else if (key > home.data) {
            door = home.kanan;
            if (door == null) {
                JOptionPane.showMessageDialog(null, "Maaf Data Tidak Ada dalam Daftar","Penghapusan Data Gagal", JOptionPane.ERROR_MESSAGE);
            }
            else if (key == door.data) {
                if (door.kanan == null & door.kiri == null) {
                    home.kanan = null;
                    current = home = root;
                    JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data","Penghapusan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            
                else if (door.kanan != null) {
                    current = door;
                    temp = current.kanan;
                    hapusnode();
                    temp.kiri = door.kiri;
                    if (temp.data != door.kanan.data) {
                        temp.kanan = door.kanan;
                    }
                    door.kiri = door.kanan = null;
                    if (home.data < temp.data) {
                        home.kanan = temp;
                    }
                    else {
                        home.kiri = temp;
                    }
                    current = home = root;
                    JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data","Penghapusan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            
                else if (door.kiri != null) {
                    current = door;
                    temp = current.kiri;
                    hapusnode();
                    if (temp.data != door.kiri.data) {
                        temp.kiri = door.kiri;
                    }
                    temp.kanan = door.kanan;
                    door.kiri = door.kanan = null;
                    if (home.data < temp.data) {
                        home.kanan = temp;
                    }
                    else {
                        home.kiri = temp;
                    }
                    current = home = root;
                    JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data","Penghapusan Data Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else {
                home = home.kanan;
                hapus (key);
            }
        }
        
        
    }
    
    public void hapusroot() {
        if (root.kanan != null) {
            if (temp.kiri != null) {
                current = temp;
                temp = temp.kiri;
                hapusroot();
            }
            else if (current==root){
                temp.kiri= root.kiri;
            }
            else if (temp.kanan != null) {
                current.kiri = temp.kanan;
            }
            else {
                current.kiri = null;
            }
        }
        
        else if (root.kiri != null) {
            if (temp.kanan != null) {
                current = temp;
                temp = temp.kanan;
                hapusroot();
            }
            else if (current==root){
                temp.kanan= root.kanan;
            }
            else if (temp.kiri != null) {
                current.kanan = temp.kiri;
            }
            else {
                current.kanan = null;
            }
        }
    }
    
    public void hapusnode() {
         if (door.kanan != null) {
            if (temp.kiri != null) {
                current = temp;
                temp = temp.kiri;
                hapusnode();
            }
            else if (temp.kanan != null) {
                if (current == door) {
                    current.kanan = temp.kanan;
                }
                else {
                    current.kiri = temp.kanan;
                }
            }
        }
        
        else if (door.kiri != null) {
            if (temp.kanan != null) {
                current = temp;
                temp = temp.kanan;
                hapusnode();
            }
            else if (temp.kiri != null) {
                if (current == door) {
                    current.kanan = temp.kiri;
                }
                else {
                    current.kiri = temp.kiri;
                }
            }
        }
    }
    
    public String pre="";
    public String in="";
    public String post="";
    
    public void printpreorder(TreeNode preprint) {
        if (kosong()) {
            JOptionPane.showMessageDialog(null, "Maaf Data Masih Kosong","Pencetakan Data Gagal", JOptionPane.ERROR_MESSAGE);
        }
        else if (preprint!= null) {
            pre = pre + preprint.data + " ";
            printpreorder(getleft(preprint));
            printpreorder(getright(preprint));
        }
    }
    
    public void printpostorder(TreeNode postprint) {
        if (kosong()) {
            JOptionPane.showMessageDialog(null, "Maaf Data Masih Kosong","Pencetakan Data Gagal", JOptionPane.ERROR_MESSAGE);
        }
        else if (postprint!= null) {
            printpostorder(getleft(postprint));
            printpostorder(getright(postprint));
            post = post + postprint.data + " ";
        }
    }
    
    public void printinorder(TreeNode inprint) {
        if (kosong()) {
            JOptionPane.showMessageDialog(null, "Maaf Data Masih Kosong","Pencetakan Data Gagal", JOptionPane.ERROR_MESSAGE);
        }
        else if (inprint!= null) {
            printinorder(getleft(inprint));
            in = in + inprint.data + " ";
            printinorder(getright(inprint));
        }
    }
    
    public TreeNode getleft(TreeNode v) {
        v = v.kiri;
        return v;
    }
    
    public TreeNode getright(TreeNode w) {
        w = w.kanan;
        return w;
    }
}


