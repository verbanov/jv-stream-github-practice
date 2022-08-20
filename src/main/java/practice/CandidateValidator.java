package practice;

import java.util.function.Predicate;
import model.Candidate;
/**
 * Your help with a election is needed. Given list of candidates, where each element
 * has Candidate.class type.
 * Check which candidates are eligible to apply for president position and return their
 * names sorted alphabetically.
 * The requirements are: person should be older than 35 years, should be allowed to vote,
 * have nationality - 'Ukrainian'
 * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
 * which has following view: "2002-2015"
 * We want to reuse our validation in future, so let's write our own impl of Predicate
 * parametrized with Candidate in CandidateValidator.
 */

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && checkYearsInUkraine(candidate.getPeriodsInUkr()));
    }

    private boolean checkYearsInUkraine(String periodsInUkr) {
        int startLiveInUkraine = Integer.parseInt(
                periodsInUkr.substring(0, periodsInUkr.indexOf("-")));
        int finishLiveInUkraine = Integer.parseInt(
                periodsInUkr.substring(periodsInUkr.indexOf("-") + 1));
        return (finishLiveInUkraine - startLiveInUkraine >= 10);
    }
}
