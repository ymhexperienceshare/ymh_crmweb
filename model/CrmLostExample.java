package com.guigu.crm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CrmLostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrmLostExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCustNoIsNull() {
            addCriterion("cust_no is null");
            return (Criteria) this;
        }

        public Criteria andCustNoIsNotNull() {
            addCriterion("cust_no is not null");
            return (Criteria) this;
        }

        public Criteria andCustNoEqualTo(String value) {
            addCriterion("cust_no =", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotEqualTo(String value) {
            addCriterion("cust_no <>", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoGreaterThan(String value) {
            addCriterion("cust_no >", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoGreaterThanOrEqualTo(String value) {
            addCriterion("cust_no >=", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLessThan(String value) {
            addCriterion("cust_no <", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLessThanOrEqualTo(String value) {
            addCriterion("cust_no <=", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLike(String value) {
            addCriterion("cust_no like", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotLike(String value) {
            addCriterion("cust_no not like", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoIn(List<String> values) {
            addCriterion("cust_no in", values, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotIn(List<String> values) {
            addCriterion("cust_no not in", values, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoBetween(String value1, String value2) {
            addCriterion("cust_no between", value1, value2, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotBetween(String value1, String value2) {
            addCriterion("cust_no not between", value1, value2, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdIsNull() {
            addCriterion("cust_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdIsNotNull() {
            addCriterion("cust_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdEqualTo(Integer value) {
            addCriterion("cust_manager_id =", value, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdNotEqualTo(Integer value) {
            addCriterion("cust_manager_id <>", value, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdGreaterThan(Integer value) {
            addCriterion("cust_manager_id >", value, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_manager_id >=", value, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdLessThan(Integer value) {
            addCriterion("cust_manager_id <", value, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("cust_manager_id <=", value, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdIn(List<Integer> values) {
            addCriterion("cust_manager_id in", values, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdNotIn(List<Integer> values) {
            addCriterion("cust_manager_id not in", values, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("cust_manager_id between", value1, value2, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_manager_id not between", value1, value2, "custManagerId");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameIsNull() {
            addCriterion("cust_manager_name is null");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameIsNotNull() {
            addCriterion("cust_manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameEqualTo(String value) {
            addCriterion("cust_manager_name =", value, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameNotEqualTo(String value) {
            addCriterion("cust_manager_name <>", value, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameGreaterThan(String value) {
            addCriterion("cust_manager_name >", value, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_manager_name >=", value, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameLessThan(String value) {
            addCriterion("cust_manager_name <", value, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameLessThanOrEqualTo(String value) {
            addCriterion("cust_manager_name <=", value, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameLike(String value) {
            addCriterion("cust_manager_name like", value, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameNotLike(String value) {
            addCriterion("cust_manager_name not like", value, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameIn(List<String> values) {
            addCriterion("cust_manager_name in", values, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameNotIn(List<String> values) {
            addCriterion("cust_manager_name not in", values, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameBetween(String value1, String value2) {
            addCriterion("cust_manager_name between", value1, value2, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andCustManagerNameNotBetween(String value1, String value2) {
            addCriterion("cust_manager_name not between", value1, value2, "custManagerName");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateIsNull() {
            addCriterion("last_order_date is null");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateIsNotNull() {
            addCriterion("last_order_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateEqualTo(Date value) {
            addCriterionForJDBCDate("last_order_date =", value, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("last_order_date <>", value, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateGreaterThan(Date value) {
            addCriterionForJDBCDate("last_order_date >", value, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_order_date >=", value, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateLessThan(Date value) {
            addCriterionForJDBCDate("last_order_date <", value, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_order_date <=", value, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateIn(List<Date> values) {
            addCriterionForJDBCDate("last_order_date in", values, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("last_order_date not in", values, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_order_date between", value1, value2, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLastOrderDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_order_date not between", value1, value2, "lastOrderDate");
            return (Criteria) this;
        }

        public Criteria andLostDateIsNull() {
            addCriterion("lost_date is null");
            return (Criteria) this;
        }

        public Criteria andLostDateIsNotNull() {
            addCriterion("lost_date is not null");
            return (Criteria) this;
        }

        public Criteria andLostDateEqualTo(Date value) {
            addCriterionForJDBCDate("lost_date =", value, "lostDate");
            return (Criteria) this;
        }

        public Criteria andLostDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("lost_date <>", value, "lostDate");
            return (Criteria) this;
        }

        public Criteria andLostDateGreaterThan(Date value) {
            addCriterionForJDBCDate("lost_date >", value, "lostDate");
            return (Criteria) this;
        }

        public Criteria andLostDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lost_date >=", value, "lostDate");
            return (Criteria) this;
        }

        public Criteria andLostDateLessThan(Date value) {
            addCriterionForJDBCDate("lost_date <", value, "lostDate");
            return (Criteria) this;
        }

        public Criteria andLostDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lost_date <=", value, "lostDate");
            return (Criteria) this;
        }

        public Criteria andLostDateIn(List<Date> values) {
            addCriterionForJDBCDate("lost_date in", values, "lostDate");
            return (Criteria) this;
        }

        public Criteria andLostDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("lost_date not in", values, "lostDate");
            return (Criteria) this;
        }

        public Criteria andLostDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lost_date between", value1, value2, "lostDate");
            return (Criteria) this;
        }

        public Criteria andLostDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lost_date not between", value1, value2, "lostDate");
            return (Criteria) this;
        }

        public Criteria andDelayIsNull() {
            addCriterion("delay is null");
            return (Criteria) this;
        }

        public Criteria andDelayIsNotNull() {
            addCriterion("delay is not null");
            return (Criteria) this;
        }

        public Criteria andDelayEqualTo(String value) {
            addCriterion("delay =", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotEqualTo(String value) {
            addCriterion("delay <>", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayGreaterThan(String value) {
            addCriterion("delay >", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayGreaterThanOrEqualTo(String value) {
            addCriterion("delay >=", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayLessThan(String value) {
            addCriterion("delay <", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayLessThanOrEqualTo(String value) {
            addCriterion("delay <=", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayLike(String value) {
            addCriterion("delay like", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotLike(String value) {
            addCriterion("delay not like", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayIn(List<String> values) {
            addCriterion("delay in", values, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotIn(List<String> values) {
            addCriterion("delay not in", values, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayBetween(String value1, String value2) {
            addCriterion("delay between", value1, value2, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotBetween(String value1, String value2) {
            addCriterion("delay not between", value1, value2, "delay");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
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