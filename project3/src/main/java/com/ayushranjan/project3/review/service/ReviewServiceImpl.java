package com.ayushranjan.project3.review.service;

import com.ayushranjan.project3.company.entity.Company;
import com.ayushranjan.project3.company.service.CompanyService;
import com.ayushranjan.project3.review.entity.Review;
import com.ayushranjan.project3.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;


    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if (companyService.getCompanyById(companyId) != null) {
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            Optional<Review> optionalReview = reviewRepository.findById(reviewId);
            if (optionalReview.isPresent()) {
                Review review = optionalReview.get();
                if (review.getCompany().getId().equals(companyId)) {
                    company.getReviews().remove(review);
                    review.setCompany(null);
                    companyService.updateCompany(companyId,company);
                    reviewRepository.deleteById(reviewId);
                    return true;
                }
            }
        }
        return false;
    }

}