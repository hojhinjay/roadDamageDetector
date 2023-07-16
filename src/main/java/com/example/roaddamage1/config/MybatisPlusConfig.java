package com.example.roaddamage1.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@MapperScan({"com.example.**.mapper"})
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        /**
         * 目前已有的功能：
         * 自动分页: PaginationInnerInterceptor
         * 多租户: TenantLineInnerInterceptor
         * 动态表名: DynamicTableNameInnerInterceptor
         * 乐观锁: OptimisticLockerInnerInterceptor
         * sql 性能规范: IllegalSQLInnerInterceptor
         * 防止全表更新与删除: BlockAttackInnerInterceptor
         */
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
