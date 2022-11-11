package com.mustache.bb3.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nation_wide_hospitals") //hospital 이라는 테이블이 아님
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {

    @Id // GenratedValue안씀
    private  Integer id;

    @Column( name = "hospital_name")
    private String hospitalName; //칼럼에 옵션을 여러가지 정할 수 있습니다. 칼럼명을 매핑할 수 잇습니다.
    private String roadNameAddress;


}
