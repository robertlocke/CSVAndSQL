package com.github.robertlocke;

import com.github.utils.DateUtil;

import java.util.Date;

public class SQLPerformanceSample {

    private long id;
    private Date createTime;
    private Date persistTime;
    private String site;
    private String config;
    private String query;
    private long numrows;
    private float fetch;
    private float total;
    private float execution;
    private String instance;
    private float open;
    private float commit;
    private float close;
    private String supportmode;
    private long localid;
    private long serverid;
    private long queueid;
    private float alertlevel;
    private float alertmax;

    public SQLPerformanceSample() {

    }

    public SQLPerformanceSample(String[] fields) {
        if (fields == null) throw new IllegalArgumentException("fields cannot be null");
        if (fields.length < 0 && fields.length > 32) throw new IllegalArgumentException("fields was either too short or too long");
        this.setId(Long.parseLong(fields[0]));
        this.setCreateTime(DateUtil.format(fields[1]));
        this.setPersistTime(DateUtil.format(fields[2]));
        this.setSite(fields[3]);
        this.setConfig(fields[4]);
        this.setQuery(fields[5]);
        this.setNumrows(Integer.parseInt(fields[6]));
        this.setFetch(Float.parseFloat(fields[7]));
        this.setTotal(Float.parseFloat(fields[8]));
        this.setExecution(Float.parseFloat(fields[9]));
        this.setInstance(fields[10]);
        this.setOpen(Float.parseFloat(fields[11]));
        this.setCommit(Float.parseFloat(fields[12]));
        this.setClose(Float.parseFloat(fields[13]));
        this.setSupportmode(fields[14]);
        this.setLocalid(Long.parseLong(fields[15]));
        this.setServerid(Long.parseLong(fields[16]));
        this.setQueueid(Long.parseLong(fields[17]));
        this.setAlertlevel(Float.parseFloat(fields[18]));
        if(fields.length > 19){
            this.setAlertmax(Float.parseFloat(fields[19]));
        }


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPersistTime() {
        return persistTime;
    }

    public void setPersistTime(Date persistTime) {
        this.persistTime = persistTime;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getCommit() {
        return commit;
    }

    public void setCommit(float commit) {
        this.commit = commit;
    }

    public long getNumrows() {
        return numrows;
    }

    public void setNumrows(long numrows) {
        this.numrows = numrows;
    }

    public float getFetch() {
        return fetch;
    }

    public void setFetch(float fetch) {
        this.fetch = fetch;
    }

    public float getExecution() {
        return execution;
    }

    public void setExecution(float execution) {
        this.execution = execution;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }


    public String getSupportmode() {
        return supportmode;
    }

    public void setSupportmode(String supportmode) {
        this.supportmode = supportmode;
    }

    public long getLocalid() {
        return localid;
    }

    public void setLocalid(long localid) {
        this.localid = localid;
    }

    public long getServerid() {
        return serverid;
    }

    public void setServerid(long serverid) {
        this.serverid = serverid;
    }

    public long getQueueid() {
        return queueid;
    }

    public void setQueueid(long queueid) {
        this.queueid = queueid;
    }

    public float getAlertlevel() {
        return alertlevel;
    }

    public void setAlertlevel(float alertlevel) {
        this.alertlevel = alertlevel;
    }

    public float getAlertmax() {
        return alertmax;
    }

    public void setAlertmax(float alertmax) {
        this.alertmax = alertmax;
    }

    @Override
    public String toString() {
        return "SQLPerformanceSample{" +
                "id=" + getId() +
                ", createTime=" + getCreateTime() +
                ", persistTime=" + getPersistTime() +
                ", site='" + getSite() + '\'' +
                ", config='" + getConfig() + '\'' +
                ", instance='" + getInstance() + '\'' +
                ", query='" + getQuery() + '\'' +
                ", total=" + getTotal() +
                '}';
    }

    public String createSQL(){
        return "DROP TABLE SQL_PERFORMANCE; CREATE TABLE SQL_PERFORMANCE( ID int, CREATETIME timestamp, PERSISTTIME timestamp, SITE varchar(200), CONFIG varchar(200), QUERY varchar(200), NUMROWS int, FETCH float, TOTAL float, EXECUTION float, INSTANCE varchar(200), OPEN float, COMMIT float, CLOSE float, SUPPORTMODE varchar(200), LOCALID int, SERVERID int, QUEUEID int, ALERTLEVEL int, ALERTMAX int );";
    }

    public String toSQL() {

        //return  "INSERT INTO SQL_PERFORMANCE (ID, CREATETIME, PERSISTTIME, SITE, CONFIG, QUERY, NUMROWS, FETCH, TOTAL, EXECUTION, INSTANCE, OPEN, COMMIT, CLOSE, SUPPORTMODE, LOCALID, SERVERID, QUEUEID, ALERTLEVEL, ALERTMAX) VALUES (" + getId() + ", TO_TIMESTAMP('" + com.github.robertlocke.DateUtil.format(getCreateTime()) + "','YYYY-MM-DD HH24:MI:SS.FF')," +  "TO_TIMESTAMP('" + com.github.robertlocke.DateUtil.format(getPersistTime()) + "',"  + "'YYYY-MM-DD HH24:MI:SS.FF')" + ",'"  + getSite() + "','" + getConfig() + "','" + getQuery() +"'," + getNumrows() + "," + getFetch() + "," + getTotal() + "," + getExecution() + ",'" + getInstance() + "'," + getOpen() + "," + getCommit() + "," + getClose() + ",'" + getSupportmode() + "'," + getLocalid() + "," + getServerid() + "," + getQueueid() + "," + getAlertlevel() + "," + getAlertmax() +");";
            return "INSERT INTO SQL_PERFORMANCE" + "(ID,"+ " CREATETIME,"+ " PERSISTTIME,"+" SITE,"+" CONFIG,"+" QUERY,"+" NUMROWS,"+" FETCH,"+" TOTAL,"+" EXECUTION,"+" INSTANCE,"+" OPEN,"+" COMMIT,"+" CLOSE,"+" SUPPORTMODE,"+" LOCALID,"+" SERVERID,"+" QUEUEID,"+" ALERTLEVEL,"+" ALERTMAX)"+ "VALUES"+ "("+getId()+","+ "TO_TIMESTAMP('"+ DateUtil.format(getCreateTime())+"','YYYY-MM-DD HH24:MI:SS.FF'),"+"TO_TIMESTAMP('"+ DateUtil.format(getPersistTime()) + "','YYYY-MM-DD HH24:MI:SS.FF'),"+"'"+getSite()+"',"+"'"+ getConfig()+"',"+"'"+ getQuery()+"',"+""+getNumrows()+","+""+getFetch()+","+""+getTotal()+","+""+getExecution()+","+"'"+getInstance()+"',"+""+getOpen()+","+""+getCommit()+","+""+getClose()+","+"'"+getSupportmode()+"',"+""+getLocalid()+","+""+getServerid()+","+""+getQueueid()+","+""+getAlertlevel()+","+""+getAlertmax()+")";

    }


}