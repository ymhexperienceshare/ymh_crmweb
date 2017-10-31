package com.guigu.crm.model;

import java.util.ArrayList;
import java.util.List;

public class CrmCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrmCustomerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNoIsNull() {
            addCriterion("no is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("no is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(String value) {
            addCriterion("no =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(String value) {
            addCriterion("no <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(String value) {
            addCriterion("no >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(String value) {
            addCriterion("no >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(String value) {
            addCriterion("no <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(String value) {
            addCriterion("no <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLike(String value) {
            addCriterion("no like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotLike(String value) {
            addCriterion("no not like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<String> values) {
            addCriterion("no in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<String> values) {
            addCriterion("no not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(String value1, String value2) {
            addCriterion("no between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(String value1, String value2) {
            addCriterion("no not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNull() {
            addCriterion("manager_id is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(Integer value) {
            addCriterion("manager_id =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(Integer value) {
            addCriterion("manager_id <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(Integer value) {
            addCriterion("manager_id >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager_id >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(Integer value) {
            addCriterion("manager_id <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("manager_id <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<Integer> values) {
            addCriterion("manager_id in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<Integer> values) {
            addCriterion("manager_id not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("manager_id between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("manager_id not between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLableIsNull() {
            addCriterion("level_lable is null");
            return (Criteria) this;
        }

        public Criteria andLevelLableIsNotNull() {
            addCriterion("level_lable is not null");
            return (Criteria) this;
        }

        public Criteria andLevelLableEqualTo(String value) {
            addCriterion("level_lable =", value, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableNotEqualTo(String value) {
            addCriterion("level_lable <>", value, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableGreaterThan(String value) {
            addCriterion("level_lable >", value, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableGreaterThanOrEqualTo(String value) {
            addCriterion("level_lable >=", value, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableLessThan(String value) {
            addCriterion("level_lable <", value, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableLessThanOrEqualTo(String value) {
            addCriterion("level_lable <=", value, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableLike(String value) {
            addCriterion("level_lable like", value, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableNotLike(String value) {
            addCriterion("level_lable not like", value, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableIn(List<String> values) {
            addCriterion("level_lable in", values, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableNotIn(List<String> values) {
            addCriterion("level_lable not in", values, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableBetween(String value1, String value2) {
            addCriterion("level_lable between", value1, value2, "levelLable");
            return (Criteria) this;
        }

        public Criteria andLevelLableNotBetween(String value1, String value2) {
            addCriterion("level_lable not between", value1, value2, "levelLable");
            return (Criteria) this;
        }

        public Criteria andSatisfyIsNull() {
            addCriterion("satisfy is null");
            return (Criteria) this;
        }

        public Criteria andSatisfyIsNotNull() {
            addCriterion("satisfy is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfyEqualTo(Integer value) {
            addCriterion("satisfy =", value, "satisfy");
            return (Criteria) this;
        }

        public Criteria andSatisfyNotEqualTo(Integer value) {
            addCriterion("satisfy <>", value, "satisfy");
            return (Criteria) this;
        }

        public Criteria andSatisfyGreaterThan(Integer value) {
            addCriterion("satisfy >", value, "satisfy");
            return (Criteria) this;
        }

        public Criteria andSatisfyGreaterThanOrEqualTo(Integer value) {
            addCriterion("satisfy >=", value, "satisfy");
            return (Criteria) this;
        }

        public Criteria andSatisfyLessThan(Integer value) {
            addCriterion("satisfy <", value, "satisfy");
            return (Criteria) this;
        }

        public Criteria andSatisfyLessThanOrEqualTo(Integer value) {
            addCriterion("satisfy <=", value, "satisfy");
            return (Criteria) this;
        }

        public Criteria andSatisfyIn(List<Integer> values) {
            addCriterion("satisfy in", values, "satisfy");
            return (Criteria) this;
        }

        public Criteria andSatisfyNotIn(List<Integer> values) {
            addCriterion("satisfy not in", values, "satisfy");
            return (Criteria) this;
        }

        public Criteria andSatisfyBetween(Integer value1, Integer value2) {
            addCriterion("satisfy between", value1, value2, "satisfy");
            return (Criteria) this;
        }

        public Criteria andSatisfyNotBetween(Integer value1, Integer value2) {
            addCriterion("satisfy not between", value1, value2, "satisfy");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(Integer value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(Integer value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(Integer value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(Integer value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(Integer value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<Integer> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<Integer> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(Integer value1, Integer value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("credit not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andZipIsNull() {
            addCriterion("zip is null");
            return (Criteria) this;
        }

        public Criteria andZipIsNotNull() {
            addCriterion("zip is not null");
            return (Criteria) this;
        }

        public Criteria andZipEqualTo(String value) {
            addCriterion("zip =", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotEqualTo(String value) {
            addCriterion("zip <>", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThan(String value) {
            addCriterion("zip >", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThanOrEqualTo(String value) {
            addCriterion("zip >=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThan(String value) {
            addCriterion("zip <", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThanOrEqualTo(String value) {
            addCriterion("zip <=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLike(String value) {
            addCriterion("zip like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotLike(String value) {
            addCriterion("zip not like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipIn(List<String> values) {
            addCriterion("zip in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotIn(List<String> values) {
            addCriterion("zip not in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipBetween(String value1, String value2) {
            addCriterion("zip between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotBetween(String value1, String value2) {
            addCriterion("zip not between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andLicenceNoIsNull() {
            addCriterion("licence_no is null");
            return (Criteria) this;
        }

        public Criteria andLicenceNoIsNotNull() {
            addCriterion("licence_no is not null");
            return (Criteria) this;
        }

        public Criteria andLicenceNoEqualTo(String value) {
            addCriterion("licence_no =", value, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoNotEqualTo(String value) {
            addCriterion("licence_no <>", value, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoGreaterThan(String value) {
            addCriterion("licence_no >", value, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoGreaterThanOrEqualTo(String value) {
            addCriterion("licence_no >=", value, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoLessThan(String value) {
            addCriterion("licence_no <", value, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoLessThanOrEqualTo(String value) {
            addCriterion("licence_no <=", value, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoLike(String value) {
            addCriterion("licence_no like", value, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoNotLike(String value) {
            addCriterion("licence_no not like", value, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoIn(List<String> values) {
            addCriterion("licence_no in", values, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoNotIn(List<String> values) {
            addCriterion("licence_no not in", values, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoBetween(String value1, String value2) {
            addCriterion("licence_no between", value1, value2, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andLicenceNoNotBetween(String value1, String value2) {
            addCriterion("licence_no not between", value1, value2, "licenceNo");
            return (Criteria) this;
        }

        public Criteria andChieftainIsNull() {
            addCriterion("chieftain is null");
            return (Criteria) this;
        }

        public Criteria andChieftainIsNotNull() {
            addCriterion("chieftain is not null");
            return (Criteria) this;
        }

        public Criteria andChieftainEqualTo(String value) {
            addCriterion("chieftain =", value, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainNotEqualTo(String value) {
            addCriterion("chieftain <>", value, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainGreaterThan(String value) {
            addCriterion("chieftain >", value, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainGreaterThanOrEqualTo(String value) {
            addCriterion("chieftain >=", value, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainLessThan(String value) {
            addCriterion("chieftain <", value, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainLessThanOrEqualTo(String value) {
            addCriterion("chieftain <=", value, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainLike(String value) {
            addCriterion("chieftain like", value, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainNotLike(String value) {
            addCriterion("chieftain not like", value, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainIn(List<String> values) {
            addCriterion("chieftain in", values, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainNotIn(List<String> values) {
            addCriterion("chieftain not in", values, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainBetween(String value1, String value2) {
            addCriterion("chieftain between", value1, value2, "chieftain");
            return (Criteria) this;
        }

        public Criteria andChieftainNotBetween(String value1, String value2) {
            addCriterion("chieftain not between", value1, value2, "chieftain");
            return (Criteria) this;
        }

        public Criteria andBankrollIsNull() {
            addCriterion("bankroll is null");
            return (Criteria) this;
        }

        public Criteria andBankrollIsNotNull() {
            addCriterion("bankroll is not null");
            return (Criteria) this;
        }

        public Criteria andBankrollEqualTo(Integer value) {
            addCriterion("bankroll =", value, "bankroll");
            return (Criteria) this;
        }

        public Criteria andBankrollNotEqualTo(Integer value) {
            addCriterion("bankroll <>", value, "bankroll");
            return (Criteria) this;
        }

        public Criteria andBankrollGreaterThan(Integer value) {
            addCriterion("bankroll >", value, "bankroll");
            return (Criteria) this;
        }

        public Criteria andBankrollGreaterThanOrEqualTo(Integer value) {
            addCriterion("bankroll >=", value, "bankroll");
            return (Criteria) this;
        }

        public Criteria andBankrollLessThan(Integer value) {
            addCriterion("bankroll <", value, "bankroll");
            return (Criteria) this;
        }

        public Criteria andBankrollLessThanOrEqualTo(Integer value) {
            addCriterion("bankroll <=", value, "bankroll");
            return (Criteria) this;
        }

        public Criteria andBankrollIn(List<Integer> values) {
            addCriterion("bankroll in", values, "bankroll");
            return (Criteria) this;
        }

        public Criteria andBankrollNotIn(List<Integer> values) {
            addCriterion("bankroll not in", values, "bankroll");
            return (Criteria) this;
        }

        public Criteria andBankrollBetween(Integer value1, Integer value2) {
            addCriterion("bankroll between", value1, value2, "bankroll");
            return (Criteria) this;
        }

        public Criteria andBankrollNotBetween(Integer value1, Integer value2) {
            addCriterion("bankroll not between", value1, value2, "bankroll");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNull() {
            addCriterion("turnover is null");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNotNull() {
            addCriterion("turnover is not null");
            return (Criteria) this;
        }

        public Criteria andTurnoverEqualTo(Integer value) {
            addCriterion("turnover =", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotEqualTo(Integer value) {
            addCriterion("turnover <>", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThan(Integer value) {
            addCriterion("turnover >", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("turnover >=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThan(Integer value) {
            addCriterion("turnover <", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThanOrEqualTo(Integer value) {
            addCriterion("turnover <=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverIn(List<Integer> values) {
            addCriterion("turnover in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotIn(List<Integer> values) {
            addCriterion("turnover not in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverBetween(Integer value1, Integer value2) {
            addCriterion("turnover between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotBetween(Integer value1, Integer value2) {
            addCriterion("turnover not between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoIsNull() {
            addCriterion("local_tax_no is null");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoIsNotNull() {
            addCriterion("local_tax_no is not null");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoEqualTo(String value) {
            addCriterion("local_tax_no =", value, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoNotEqualTo(String value) {
            addCriterion("local_tax_no <>", value, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoGreaterThan(String value) {
            addCriterion("local_tax_no >", value, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoGreaterThanOrEqualTo(String value) {
            addCriterion("local_tax_no >=", value, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoLessThan(String value) {
            addCriterion("local_tax_no <", value, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoLessThanOrEqualTo(String value) {
            addCriterion("local_tax_no <=", value, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoLike(String value) {
            addCriterion("local_tax_no like", value, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoNotLike(String value) {
            addCriterion("local_tax_no not like", value, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoIn(List<String> values) {
            addCriterion("local_tax_no in", values, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoNotIn(List<String> values) {
            addCriterion("local_tax_no not in", values, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoBetween(String value1, String value2) {
            addCriterion("local_tax_no between", value1, value2, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andLocalTaxNoNotBetween(String value1, String value2) {
            addCriterion("local_tax_no not between", value1, value2, "localTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoIsNull() {
            addCriterion("nation_tax_no is null");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoIsNotNull() {
            addCriterion("nation_tax_no is not null");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoEqualTo(String value) {
            addCriterion("nation_tax_no =", value, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoNotEqualTo(String value) {
            addCriterion("nation_tax_no <>", value, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoGreaterThan(String value) {
            addCriterion("nation_tax_no >", value, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoGreaterThanOrEqualTo(String value) {
            addCriterion("nation_tax_no >=", value, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoLessThan(String value) {
            addCriterion("nation_tax_no <", value, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoLessThanOrEqualTo(String value) {
            addCriterion("nation_tax_no <=", value, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoLike(String value) {
            addCriterion("nation_tax_no like", value, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoNotLike(String value) {
            addCriterion("nation_tax_no not like", value, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoIn(List<String> values) {
            addCriterion("nation_tax_no in", values, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoNotIn(List<String> values) {
            addCriterion("nation_tax_no not in", values, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoBetween(String value1, String value2) {
            addCriterion("nation_tax_no between", value1, value2, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationTaxNoNotBetween(String value1, String value2) {
            addCriterion("nation_tax_no not between", value1, value2, "nationTaxNo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}