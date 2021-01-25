package backoffice.back.jpa_auditing;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class auditingclasse<T> {
    @CreatedBy
    @Column
    protected T createdby;
    @LastModifiedBy
    @Column
    protected T modifiedby;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    protected Date createddate;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    protected Date modifieddate;

    public T getCreatedby() {
        return createdby;
    }

    public void setCreatedby(T createdby) {
        this.createdby = createdby;
    }

    public T getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(T modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }
}
