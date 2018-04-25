package org.taiko.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.taiko.entity.MirrorPengundi;
import org.taiko.form.PengundiForm;

public class PengundiDao {
	
	JdbcTemplate template; 

	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}

	public PengundiForm getPengundiByNoKp(String noKp) {
		 String sql="select * from pengundi where no_kp=?";  
		 PengundiForm form = new PengundiForm();
		 try {
			 form = template.queryForObject(sql, new Object[]{noKp},new BeanPropertyRowMapper<PengundiForm>(PengundiForm.class));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			form = new PengundiForm();
		}
		return form;
		      
	}

	public void save(PengundiForm form) {
		
		String sql = "update pengundi set nama = '"+form.getNama()+"', "
	+ "jantina = '"+form.getJantina()+"', dm = '"+form.getDm()+"', "
			+ "kod_lokaliti = '"+form.getKod_lokaliti()+"', lokaliti = '"+form.getLokaliti()+"', "
					+ "kump_umur = '"+form.getKump_umur()+"', kump_kaum='"+form.getKump_kaum()+"', "
							+ "tel_no1 = '"+form.getTel_no1()+"', tel_no2='"+form.getTel_no2()+"', alamat='"+form.getAlamat()+"', "
									+ "alamat_st4 ='"+form.getAlamat_st4()+"', category_a ='"+form.getCategory_a()+"', "
											+ "category_b = '"+form.getCategory_b()+"', category_c='"+form.getCategory_c()+"', "
													+ "category_d ='"+form.getCategory_d()+"', category_e='"+form.getCategory_e()+"', "
															+ "category_f='"+form.getCategory_f()+"', category_g='"+form.getCategory_g()+"', category_h='"+form.getCategory_h()+"', "
																	+ "flag_masuk ='"+form.getFlag_masuk()+"', flag_keluar='"+form.getFlag_keluar()+"', "
																			+ "status_pengundi ='"+form.getStatus_pengundi()+"', status_alamat ='"+form.getFlag_keluar()+"' "
																					+ "where no_kp='"+form.getNo_kp()+"'";
								
		
		template.update(sql);
		

		
	}  
	
	public List<MirrorPengundi> getPengundiByPage(int pageid,int total){  
	    String sql="select * from mirror_pengundi order by nama offset "+(pageid)+" limit "+total;  
	    return template.query(sql,new RowMapper<MirrorPengundi>(){  
	        public MirrorPengundi mapRow(ResultSet rs, int row) throws SQLException {  
	        	MirrorPengundi mp = new MirrorPengundi(); 
	        	mp.setNoKp(rs.getString(1));
	        	mp.setNama(rs.getString(2));
	            return mp;  
	        }  
	    });  
	}

	public int getLastPage() {
		String sql="select count(no_kp)/50 from mirror_pengundi";  
	    return template.queryForInt(sql);
	}  

}
