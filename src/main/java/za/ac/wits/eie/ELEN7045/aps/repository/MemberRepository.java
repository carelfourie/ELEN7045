package za.ac.wits.eie.ELEN7045.aps.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import za.ac.wits.eie.ELEN7045.aps.model.Member;
import za.ac.wits.eie.ELEN7045.aps.repository.base.BaseRepository;

@ApplicationScoped
public class MemberRepository extends BaseRepository {

	public List<Member> findAllOrderedByName() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
		Root<Member> member = criteria.from(Member.class);
		criteria.select(member).orderBy(cb.asc(member.get("name")));
		return entityManager.createQuery(criteria).getResultList();
	}

	public Member findByEmail(String email) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
		Root<Member> member = criteria.from(Member.class);
		criteria.select(member).where(cb.equal(member.get("email"), email));
		return entityManager.createQuery(criteria).getSingleResult();
	}

	public Member findById(Long id) {
		return entityManager.find(Member.class, id);
	}
}
