package com.binary.junit.repository;

import com.binary.junit.model.Office;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OfficeRepository {
    void updateAddress(Office office);
}
